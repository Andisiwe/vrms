package za.ac.cput.vrms.forms;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;

/**
 * Created by Andies on 2015-10-31.
 */
@Theme("mytheme")
@SpringUI
public class Homepage extends UI {

        @Override
        protected void init(VaadinRequest vaadinRequest) {
            VerticalLayout verticalLayout = new VerticalLayout();
            verticalLayout.setStyleName("backcolor");
            Label welcomeNote = new Label("Hello! Welcome to South Point Residence!");
            welcomeNote.setStyleName("labelstyle");

            GridLayout gridLayout = new GridLayout(1,9);
            gridLayout.setStyleName("menu");
            Label label = new Label("Menu");
            label.setStyleName("heading");
            Button btnViewCities = new Button("View Cities");
            Button btnViewResidences = new Button("View Residences");
            Button btnViewRooms = new Button("View Rooms");
            gridLayout.addComponent(label);
            gridLayout.addComponent(btnViewCities);
            gridLayout.addComponent(btnViewResidences);
            gridLayout.addComponent(btnViewRooms);

            verticalLayout.addComponent(welcomeNote);
            verticalLayout.addComponent(gridLayout);
            setContent(verticalLayout);
        }

}
