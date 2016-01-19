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
    Object selected;
    Object selectedRes;
    Object selectedRoom;

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
        cityGrid.setColumnOrder("id", "name", "code");

        HorizontalLayout cityLayout = new HorizontalLayout();
        HorizontalLayout resLayout = new HorizontalLayout();
        HorizontalLayout roomLayout = new HorizontalLayout();

        cityLayout.addComponent(cityGrid);
        name = new TextField("City Name");
        code = new TextField("Code");
        cityForm.addComponent(name);
        cityForm.addComponent(code);

        Button save = new Button("Save", this::saveCity);
        Button cancel = new Button("Cancel", this::cancel);
        Button update = new Button("Update", this::updateCity);
        cityForm.addComponent(save);
        cityForm.addComponent(update);
        cityForm.addComponent(cancel);
        cityLayout.addComponent(cityForm);

        resLayout.addComponent(residenceGrid);
        resName = new TextField("Residence Name");
        town = new TextField("Town");
        resForm.addComponent(resName);
        resForm.addComponent(town);

        Button saveResi = new Button("Save", this::saveRes);
        Button cancelRes = new Button("Cancel", this::cancel);
        Button updateRes = new Button("Update", this::updateRes);
        resForm.addComponent(saveResi);
        resForm.addComponent(updateRes);
        resForm.addComponent(cancelRes);
        resLayout.addComponent(resForm);

        roomLayout.addComponent(roomGrid);
        roomType = new TextField("Room Type");
        roomForm.addComponent(roomType);

        Button saveRoom = new Button("Save", this::saveRoom);
        Button cancelRoom = new Button("Cancel", this::cancel);
        Button updateRoom = new Button("Update", this::updateRoom);
        roomForm.addComponent(saveRoom);
        roomForm.addComponent(updateRoom);
        roomForm.addComponent(cancelRoom);
        roomLayout.addComponent(roomForm);

        cityGrid.addSelectionListener(selectionEvent -> {
            selected = ((Grid.SingleSelectionModel)
                    cityGrid.getSelectionModel()).getSelectedRow();

            Notification.show("Selected " +
                    cityGrid.getContainerDataSource().getItem(selected)
                            .getItemProperty("name"));

            String cityName = String.valueOf(cityGrid.getContainerDataSource().getItem(selected)
                    .getItemProperty("name"));
            String cityCode = String.valueOf(cityGrid.getContainerDataSource().getItem(selected)
                    .getItemProperty("code"));

            name.setValue(cityName);
            code.setValue(cityCode);
        });

        residenceGrid.addSelectionListener(selectionEvent -> {
            selectedRes = ((Grid.SingleSelectionModel)
                    residenceGrid.getSelectionModel()).getSelectedRow();

            Notification.show("Selected " +
                    residenceGrid.getContainerDataSource().getItem(selectedRes)
                            .getItemProperty("name"));

            String n = String.valueOf(residenceGrid.getContainerDataSource().getItem(selectedRes)
                    .getItemProperty("name"));
            String resTown = String.valueOf(residenceGrid.getContainerDataSource().getItem(selectedRes)
                    .getItemProperty("town"));

            resName.setValue(n);
            town.setValue(resTown);
        });

        roomGrid.addSelectionListener(selectionEvent -> {
            selectedRoom = ((Grid.SingleSelectionModel)
                    roomGrid.getSelectionModel()).getSelectedRow();

            Notification.show("Selected " +
                    roomGrid.getContainerDataSource().getItem(selectedRoom)
                            .getItemProperty("type"));

            String t = String.valueOf(roomGrid.getContainerDataSource().getItem(selectedRoom)
                    .getItemProperty("type"));

            roomType.setValue(t);
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

            name.setValue("");
            code.setValue("");
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

    public void updateCity(Button.ClickEvent event) {
        try {
            String cityid = String.valueOf(cityGrid.getContainerDataSource().getItem(selected)
                    .getItemProperty("id"));
            Long id = Long.parseLong(cityid);
            city = cityService.findById(id);

            City updateCity = new City.Builder(city.getName())
                    .copy(city)
                    .code(code.getValue())
                    .build();
            cityService.update(updateCity);

            String msg = String.format("Updated city at ID '%s'.",
                    city.getId());

            Notification.show(msg, Notification.Type.TRAY_NOTIFICATION);

        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void updateRes(Button.ClickEvent event) {
        try{
            String resId = String.valueOf(residenceGrid.getContainerDataSource().getItem(selectedRes)
                    .getItemProperty("id"));
            Long id = Long.parseLong(resId);
            res = residenceService.findById(id);

            Residence updatedRes = new Residence.Builder(res.getName())
                    .copy(res)
                    .town(town.getValue())
                    .build();
            residenceService.update(updatedRes);


            String msg = String.format("Updated residence at ID '%s'.",
                    res.getId());
            Notification.show(msg, Notification.Type.TRAY_NOTIFICATION);

        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void updateRoom(Button.ClickEvent event) {
        try {
            String roomId = String.valueOf(roomGrid.getContainerDataSource().getItem(selectedRoom)
                    .getItemProperty("id"));
            Long id = Long.parseLong(roomId);
            room = roomService.findById(id);

            Room updatedRoom = new Room.Builder(roomType.getValue())
                    .copy(room)
                    .build();
            roomService.update(updatedRoom);

            String msg = String.format("Updated room at ID '%s'.",
                    room.getId());
            Notification.show(msg, Notification.Type.TRAY_NOTIFICATION);

        } catch (Exception e) {
            e.getMessage();
        }
    }
}
