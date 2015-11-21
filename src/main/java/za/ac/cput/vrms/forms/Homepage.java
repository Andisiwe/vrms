package za.ac.cput.vrms.forms;

import com.vaadin.annotations.Theme;
import com.vaadin.spring.annotation.SpringUI;

/**
 * Created by Andies on 2015-10-31.
 */
@Theme("mytheme")
@SpringUI
public class Homepage {/*extends UI {

        @Override
        protected void init(VaadinRequest vaadinRequest) {
            getPage().setTitle("Home Page");
            VerticalLayout verticalLayout = new VerticalLayout();
            verticalLayout.setStyleName("backcolor");
            Label welcomeNote = new Label("Hello! Welcome to South Point Residence!");
            welcomeNote.setStyleName("labelstyle");

            HorizontalLayout horizontalLayout = new HorizontalLayout();
            Label label = new Label("Menu");
            label.setStyleName("heading");
            Button book = new Button("Book A Room", new Button.ClickListener(){
                @Override
                public void buttonClick(Button.ClickEvent event){
                    new ReserveRoomPage();
                }});

            horizontalLayout.addComponent(label);
            horizontalLayout.addComponent(book);

            verticalLayout.addComponent(welcomeNote);
            verticalLayout.addComponent(horizontalLayout);
            setContent(verticalLayout);
        }*/

}
