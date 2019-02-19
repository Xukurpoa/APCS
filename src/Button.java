/**
 * Button
 * This interface represents a button.
 * The button should be able to be pushed.
 * Ideally, pushing the button changes its state.
 */
public interface Button
{
    /**
     * Push the button. The internal state of the button
     * should change.
     */
    public void push();

    /**
     * Return the current state of the button without changing it.
     */
    public String state();
}