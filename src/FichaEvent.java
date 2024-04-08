import java.awt.*;
import java.util.EventObject;

public class FichaEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    private boolean mostrar;

    public FichaEvent(Object source,boolean mostrar) {
        super(source);
        this.mostrar= mostrar;
    }
}
