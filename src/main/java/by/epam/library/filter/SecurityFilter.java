package by.epam.library.filter;

import by.epam.library.model.entity.Person;
import by.epam.library.model.entity.TypePerson;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SecurityFilter implements Filter {


    private static final String USER_SESSION_ATTRIBUTE = "user";

    private static final String ADMIN_PAGE_PATH_PATTERN = ".*/jsp/admin/.*.jsp";
    private static final String LIBRARIAN_PAGE_PATH_PATTERN = ".*/jsp/librarian/.*.jsp";
    private static final String READER_PAGE_PATH_PATTERN = ".*/jsp/reader/.*.jsp";

    private static final String MAIN_PAGE_PARAMETER = "MAIN_PAGE";

    private String mainPage;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        mainPage = filterConfig.getInitParameter(MAIN_PAGE_PARAMETER);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        String currentPage = httpServletRequest.getServletPath();

        HttpSession session = httpServletRequest.getSession();
        Person person = (Person) session.getAttribute(USER_SESSION_ATTRIBUTE);


        if(!mainPage.equals(currentPage)) {
            if (person == null) {
                httpServletResponse.sendRedirect(mainPage);

            } else {
                TypePerson typePerson = person.getRole( );
                boolean isRightUser = checkRole(typePerson, currentPage);

                if (!isRightUser) {
                    httpServletResponse.sendRedirect(mainPage);
                }
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }

    private boolean checkRole(TypePerson typePerson, String pagePath){
        switch (typePerson){
            case ADMIN:{
                return checkPath(pagePath, ADMIN_PAGE_PATH_PATTERN);
            }
            case READER:{
                return checkPath(pagePath, READER_PAGE_PATH_PATTERN);
            }
            case LIBRARIAN:{
                return checkPath(pagePath, LIBRARIAN_PAGE_PATH_PATTERN);
            }
            default:{
                return false;
            }
        }
    }

    private boolean checkPath(String path, String pagePattern){
        Pattern pattern = Pattern.compile(pagePattern);
        Matcher matcher = pattern.matcher(path);

        return matcher.matches();
    }
}
