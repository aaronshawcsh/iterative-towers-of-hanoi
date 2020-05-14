import java.util.InputMismatchException;
import java.util.Arrays;

public class TowersOfHanoi {
    public static void main(String[] args) {
        testPrintSequence();
    }
    public static void testPrintSequence() {
        int numberOfDisks = 4;
        try {
            System.out.println(Arrays.toString(generateDiskMovementSequence(numberOfDisks)));
        } catch(InputMismatchException e) {
            System.out.println("The number of disks cannot be less than 1.");
        }
    }
    public static int[] generateDiskMovementSequence(int numberOfDisks) throws InputMismatchException {
        if(numberOfDisks < 1) throw new InputMismatchException();
        else if(numberOfDisks == 1) return new int[] {1};
        else {
            int sequenceLength = (int) (Math.pow(2, numberOfDisks) - 1);
            int[] sequence = new int[sequenceLength];
            int constant = numberOfDisks, alternate = numberOfDisks - 1, alternateChanger = -1;
            for(int i = 0; i < sequenceLength / 2; i++) {
                if(alternate == 2) alternateChanger = 1;
                else if(alternate == numberOfDisks - 1) alternateChanger = -1;
                if(i % 2 == 0) {
                    sequence[i] = constant;
                    sequence[sequenceLength - 1 - i] = constant;
                }  else {
                    sequence[i] = alternate;
                    sequence[sequenceLength - 1 - i] = alternate;
                    alternate += alternateChanger;
                }
            }
            sequence[sequenceLength / 2] = 1;
            return sequence;
        }
    }
}
