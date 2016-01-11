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
import za.ac.cput.vrms.factories.CityFactory;
import za.ac.cput.vrms.factories.ResidenceFactory;
import za.ac.cput.vrms.factories.RoomFactory;
import za.ac.cput.vrms.services.CityService;
import za.ac.cput.vrms.services.ResidenceService;
import za.ac.cput.vrms.services.RoomService;

/**
 * Created by Andies on 2015-11-04.
 */
@Theme("mytheme")
@SpringUI
public class ReadTables extends UI {
    Grid cityGrid;
    CityService cityService;
    Grid residenceGrid;
    ResidenceService residenceService;
    Grid roomGrid;
    RoomService roomService;
    VerticalLayout verticalLayout = new VerticalLayout();

    City city;
    Residence res;
    Room room;
    TextField name;
    TextField code;
    TextField town;
    TextField resName;
    TextField roomType;
    VerticalLayout cityForm = new VerticalLayout();
    VerticalLayout resForm = new VerticalLayout();
    VerticalLayout roomForm = new VerticalLayout();

    public ReadTables(){}

    @Autowired
    public ReadTables(CityService cityService, ResidenceService residenceService, RoomService roomService){
        this.cityService = cityService;
        this.cityGrid = new Grid("City");
        this.residenceService = residenceService;
        this.residenceGrid = new Grid("Residence");
        this.roomService = roomService;
        this.roomGrid = new Grid("Room");
    }

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        cityGrid.setContainerDataSource(new BeanItemContainer(City.class, cityService.findAll()));
        residenceGrid.setContainerDataSource(new BeanItemContainer(Residence.class, residenceService.findAll()));
        roomGrid.setContainerDataSource(new BeanItemContainer(Room.class, roomService.findAll()));
        cityGrid.setColumnOrder("id","name","code");
        Label cityLabel = new Label("City");
        cityLabel.setStyleName("heading");
        Label resLabel = new Label("Residence");
        resLabel.setStyleName("heading");
        Label roomLabel = new Label("Room");
        roomLabel.setStyleName("heading");

        HorizontalLayout cityLayout = new HorizontalLayout();
        HorizontalLayout resLayout = new HorizontalLayout();
        HorizontalLayout roomLayout = new HorizontalLayout();

        cityLayout.addComponent(cityLabel);
        cityLayout.addComponent(cityGrid);
        name = new TextField("City Name");
        code = new TextField("Code");
        cityForm.addComponent(name);
        cityForm.addComponent(code);

        Button save = new Button("Save", this::saveCity);
        Button cancel = new Button("Cancel", this::cancel);
        cityForm.addComponent(save);
        cityForm.addComponent(cancel);
        cityLayout.addComponent(cityForm);

        resLayout.addComponent(resLabel);
        resLayout.addComponent(residenceGrid);
        resName = new TextField("Residence Name");
        town = new TextField("Town");
        resForm.addComponent(resName);
        resForm.addComponent(town);

        Button saveResi = new Button("Save", this::saveRes);
        Button cancelRes = new Button("Cancel", this::cancel);
        resForm.addComponent(saveResi);
        resForm.addComponent(cancelRes);
        resLayout.addComponent(resForm);

        roomLayout.addComponent(roomLabel);
        roomLayout.addComponent(roomGrid);
        roomType = new TextField("Room Type");
        roomForm.addComponent(roomType);

        Button saveRoom = new Button("Save", this::saveRoom);
        Button cancelRoom = new Button("Cancel", this::cancel);
        roomForm.addComponent(saveRoom);
        roomForm.addComponent(cancelRoom);
        roomLayout.addComponent(roomForm);

        cityGrid.addSelectionListener(selectionEvent -> {
            Object selected = ((Grid.SingleSelectionModel)
                    cityGrid.getSelectionModel()).getSelectedRow();

            Notification.show("Selected " +
                    cityGrid.getContainerDataSource().getItem(selected)
                            .getItemProperty("name"));
        });

        residenceGrid.addSelectionListener(selectionEvent -> {
            Object selectedRes = ((Grid.SingleSelectionModel)
                    residenceGrid.getSelectionModel()).getSelectedRow();

            Notification.show("Selected " +
                    residenceGrid.getContainerDataSource().getItem(selectedRes)
                            .getItemProperty("name"));
        });

        roomGrid.addSelectionListener(selectionEvent -> {
            Object selectedRoom = ((Grid.SingleSelectionModel)
                    roomGrid.getSelectionModel()).getSelectedRow();

            Notification.show("Selected " +
                    roomGrid.getContainerDataSource().getItem(selectedRoom)
                            .getItemProperty("type"));
        });

        verticalLayout.addComponent(cityLayout);
        verticalLayout.addComponent(resLayout);
        verticalLayout.addComponent(roomLayout);
        setContent(verticalLayout);

    }

    public void saveCity(Button.ClickEvent event) {
        try{
            city = CityFactory.createCity(name.getValue(), code.getValue());
            cityService.save(city);

            String msg = String.format("Saved '%s'.",
                    city.getName());
            Notification.show(msg, Notification.Type.TRAY_NOTIFICATION);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void saveRes(Button.ClickEvent event) {
        try{
            res = ResidenceFactory.createResidence(resName.getValue(), town.getValue());
            residenceService.save(res);

            String msg = String.format("Saved '%s'.",
                    res.getName());
            Notification.show(msg, Notification.Type.TRAY_NOTIFICATION);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void saveRoom(Button.ClickEvent event) {
        try{
            room = RoomFactory.createRoom(roomType.getValue());
            roomService.save(room);

            String msg = String.format("Saved '%s'.",
                    room.getType());
            Notification.show(msg, Notification.Type.TRAY_NOTIFICATION);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void cancel(Button.ClickEvent event) {
        Notification.show("Cancelled", Notification.Type.TRAY_NOTIFICATION);
        cityGrid.select(null);
    }

    public void selectCity(){
        //cityGrid.addSelectionListener().addListener(new ItemClickEvent.ItemClickListener() {

          //  @Override
          //  public void itemClick(ItemClickEvent event) {

           //     Property itemProperty = event.getItem().getItemProperty("cellphone");
             //   itemProperty.getValue();

           // }
        //});

      /*  cityGrid.addSelectionListener(new SelectionEvent.SelectionListener() {

            @Override
            public void select(SelectionEvent event) {
                Notification.show("Select row: "+cityGrid.getSelectedRow());
            }
        });*/
    }

}
