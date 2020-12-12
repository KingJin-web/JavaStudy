package D1121;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class UserCountListener implements HttpSessionAttributeListener {
    private int count = 0;
    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
        httpSessionBindingEvent.getSession();
        httpSessionBindingEvent.getName();
        httpSessionBindingEvent.getValue();
        if ("loginedAccount".equals(httpSessionBindingEvent.getName())){
            count++;
            httpSessionBindingEvent.getSession().getServletContext().setAttribute("count",count);
        }
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {
        if ("loginedAccount".equals(httpSessionBindingEvent.getName())){
            count--;
            httpSessionBindingEvent.getSession().getServletContext().setAttribute("count",count);
        }
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {

    }
}
