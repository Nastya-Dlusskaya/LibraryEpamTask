package by.epam.library.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class Pagination extends SimpleTagSupport {

    Integer currentPage;
    Integer maxPage;
    String command;
    Integer userId;

    public void setCommand(String command) {
        this.command = command;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public void setMaxPage(Integer maxPage) {
        this.maxPage = maxPage;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public void doTag() throws JspException, IOException {

        JspWriter out = getJspContext( ).getOut( );
        out.print("<div class=\"pagination\">");

        if(maxPage == 2){
            out.print(createPageLink(1));
            out.print(createPageLink(2));
        }else if(maxPage == 3){
            out.print(createPageLink(1));
            out.print(createPageLink(2));
            out.print(createPageLink(3));
        }else {

            if (currentPage >= 3) {
                out.print(createPageLink(1));
                if (currentPage > 3) {
                    out.print(createEllipse());
                }
            }

            if (currentPage == 1) {
                for (int i = currentPage, j = 0; j < 3 && j < maxPage; i++, j++) {
                    out.print(createPageLink(i));
                }
            } else if (currentPage == maxPage) {
                for (int i = currentPage - 2, j = 0; j < 3 && j < maxPage; i++, j++) {
                    out.print(createPageLink(i));
                }
            } else {
                for (int i = currentPage - 1, j = 0; j < 3 && j < maxPage; i++, j++) {
                    out.print(createPageLink(i));
                }
            }

            if (currentPage <= maxPage - 2) {
                if (currentPage < maxPage - 2) {
                    out.print(createEllipse());
                }
                out.print(createPageLink(maxPage));
            }

        }

    }

    private String createPageLink(int page) {

        StringBuilder form = new StringBuilder( );

        form.append("<a href=\"/controller?command=").append(command).
                append("&page=")
                .append(page).
                append("\">")
                .append(page)
                .append("</a>");

        return form.toString( );
    }

    private String createEllipse(){
        return "<a href=\" \"> ..... </a>";
    }
}