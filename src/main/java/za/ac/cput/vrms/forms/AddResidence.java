package za.ac.cput.vrms.forms;

import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import za.ac.cput.vrms.domain.City;

/**
 * Created by Andies on 2015-12-27.
 */
@SpringUI
public class AddResidence extends FormLayout {
    BeanFieldGroup<City> formFieldBindings;
    City city;

    TextField name = new TextField("City Name");
    TextField code = new TextField("Code");
    Button save = new Button("Save", this::save);
    Button cancel = new Button("Cancel", this::cancel);

    void add(City city) {
        this.city = city;
        if(city != null) {
            formFieldBindings = BeanFieldGroup.bindFieldsBuffered(city, this);
            name.focus();
        }
        setVisible(city != null);
    }

    public void save(Button.ClickEvent event) {
        try {
            formFieldBindings.commit();
            getUI().cityService.save(city);

            String msg = String.format("Saved '%s'.",
                    city.getName());
            Notification.show(msg, Notification.Type.TRAY_NOTIFICATION);
        } catch (FieldGroup.CommitException e) {
            e.getMessage();
        }
    }

    public void cancel(Button.ClickEvent event) {
        Notification.show("Cancelled", Notification.Type.TRAY_NOTIFICATION);
        getUI().cityGrid.select(null);
    }

    @Override
    public ReadTables getUI() {
        return (ReadTables) super.getUI();
    }

}
