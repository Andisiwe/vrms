package za.ac.cput.vrms.forms;

import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;

/**
 * Created by Andies on 2015-10-31.
 */
@SpringUI
public class Homepage extends UI {

        @Override
        protected void init(VaadinRequest vaadinRequest) {
            setContent(new Label("Hello! Welcome to South Point Residence!"));
        }

}
