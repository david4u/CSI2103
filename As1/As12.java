package As1;

public class As12 {/*
    public static void main(String[] args) {
        Oracle o = new Oracle();
        int tofind, n, mid, a;
        boolean found;
        
        // Get what to find and array's size
        tofind = o.getWhatToFind();
        n = o.getN();

        // Set initial value of left and right
        int left = 0;
        int right = n - 1;
        found = false;

        // binary searching
        while (left <= right) {
            mid = (left + right) / 2;
            a = o.getElementAt(mid);
            if (a == tofind) {
                o.reportAnswer(true, mid);
                found = true;
                break;
            }
            if (a > tofind) {
                right = mid - 1;
            }
            if (a < tofind) {
                left = mid + 1;
            }
        }

        // searching fail no value to find in the array
        if (!found) {
            o.reportAnswer(false, 0);
        }

    }
*/
}