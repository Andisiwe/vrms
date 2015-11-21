package za.ac.cput.vrms.forms;

import com.vaadin.annotations.Theme;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.vrms.domain.City;
import za.ac.cput.vrms.domain.Residence;
import za.ac.cput.vrms.domain.Room;
import za.ac.cput.vrms.services.CityService;
import za.ac.cput.vrms.services.ResidenceService;
import za.ac.cput.vrms.services.RoomService;

/**
 * Created by Andies on 2015-11-04.
 */
@Theme("mytheme")
@SpringUI
public class ReserveRoomPage extends UI {
    Grid cityGrid;
    CityService cityService;
    Grid residenceGrid;
    ResidenceService residenceService;
    Grid roomGrid;
    RoomService roomService;
    HorizontalLayout  horizontalLayout = new  HorizontalLayout();
    HorizontalLayout  horizontalLayout2 = new  HorizontalLayout();
    VerticalLayout  verticalLayout = new VerticalLayout();

    public ReserveRoomPage(){}

    @Autowired
    public ReserveRoomPage(CityService cityService, ResidenceService residenceService, RoomService roomService){
        this.cityService = cityService;
        this.cityGrid = new Grid();
        this.residenceService = residenceService;
        this.residenceGrid = new Grid();
        this.roomService = roomService;
        this.roomGrid = new Grid();
    }

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        cityGrid.setContainerDataSource(new BeanItemContainer(City.class, cityService.findAll()));
        residenceGrid.setContainerDataSource(new BeanItemContainer(Residence.class, residenceService.findAll()));
        roomGrid.setContainerDataSource(new BeanItemContainer(Room.class, roomService.findAll()));

        Label cityLabel = new Label("City");
        cityLabel.setStyleName("heading");
        Label resLabel = new Label("Residence");
        resLabel.setStyleName("heading");
        Label roomLabel = new Label("Room");
        roomLabel.setStyleName("heading");

        horizontalLayout.addComponent(cityLabel);
        horizontalLayout.addComponent(cityGrid);
        horizontalLayout.addComponent(resLabel);
        horizontalLayout.addComponent(residenceGrid);
        horizontalLayout2.addComponent(roomLabel);
        horizontalLayout2.addComponent(roomGrid);
        verticalLayout.addComponent(horizontalLayout);
        verticalLayout.addComponent(horizontalLayout2);
        setContent(verticalLayout);
    }
}
