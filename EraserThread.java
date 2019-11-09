/*
 * Support object to mask password (or key in this case)
 * created by: Vijay Shanker Dubey
 * Found on stackoverflow: https://stackoverflow.com/questions/10819469/hide-input-on-command-line
 */

public class EraserThread implements Runnable {
    private boolean stop;

    /**
     *@param prompt displayed to the user
     */
    public EraserThread(String prompt) {
        System.out.println(prompt);
    }

    /**
     * Begin masking...display asterisks (*)
     */
    public void run () {
        stop = true;
        while (stop) {
            System.out.print("\010");
            try {
                Thread.currentThread().sleep(1);
            } catch(InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }

    /**
     * Instruct the thread to stop masking
     */
    public void stopMasking() {
        this.stop = false;
    }
}