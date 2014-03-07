package de.dpunkt.myaktion.data;

import de.dpunkt.myaktion.model.Aktion;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@SessionScoped
@Named
public class AktionProducer implements Serializable {

    private static final long serialVersionUID = -1828660647917534556L;

    private enum Mode {
        EDIT, ADD
    }

    private Aktion aktion;
    private Mode mode;

    public Aktion getSelectedAktion() {
        return aktion;
    }

    public void setSelectedAktion(Aktion aktion) {
        this.aktion = aktion;
    }

    public boolean isAddMode() {
        return mode == Mode.ADD;
    }

    public void prepareAddAktion() {
        this.aktion = new Aktion();
        this.mode = Mode.ADD;
    }

    public void prepareEditAktion(Aktion aktion) {
        this.aktion = aktion;
        this.mode = Mode.EDIT;
    }

}
