package arraylisttests;

import arraylists.ArrayList;
import lists.ListInterface;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;

public class ArrayListTest {
    private final ListInterface<Integer> list = new ArrayList<>();

    @Test
    public void addInitialElement() {
        list.add(1);
        var result = list.get(0) == 1 && list.contains(1) && !list.isEmpty() && list.size() == 1 && list.indexOf(1) == 0;
        Assertions.assertTrue(result);
    }

    @Test
    public void addElementsBeyondCapacity() {
        for(int i = 0; i < 25; i++) {
            list.add(i + 1);
        }
        var result = list.size() == 25 && !list.isEmpty();
        Assertions.assertTrue(result);
    }

    @Test
    public void checkInitialResizedCapacity() {
        for(int i = 0; i < 10; i++) {
            list.add(i + 1);
        }
        var result = list.getCapacity();
        Assertions.assertEquals(20, result);
    }

    @Test
    public void useContainsOnNullElement() {
        var result = list.contains(null);
        Assertions.assertFalse(result);
    }

    @Test
    public void useContainsOnValidElement() {
        list.add(1);
        var result = list.contains(1);
        Assertions.assertTrue(result);
    }

    @Test
    public void useContainsOnInvalidElement() {
        var result = list.contains(1);
        Assertions.assertFalse(result);
    }

    @Test
    public void removeElementResultingInEmptyList() {
        list.add(1);
        list.remove(1);
        var result = !list.contains(1) && list.size() == 0 && list.isEmpty() && list.get(0) == null;
        Assertions.assertTrue(result);
    }

    @Test
    public void removeFirstElementInPopulatedList() {
        for(int i = 0; i < 5; i++) {
            list.add(i + 1);
        }
        list.remove(1);
        var result = !list.contains(1) && list.get(0) == 2 && list.size() == 4;
        Assertions.assertTrue(result);
    }

    @Test
    public void removeLastElementInPopulatedList() {
        for(int i = 0; i < 5; i++) {
            list.add(i + 1);
        }
        list.remove(5);
        var result = !list.contains(5) && list.get(4) == null && list.size() == 4;
        Assertions.assertTrue(result);
    }

    @Test
    public void removeMiddleElementInPopulatedList() {
        for(int i = 0; i < 5; i++) {
            list.add(i + 1);
        }
        list.remove(3);
        var result = !list.contains(3) && list.get(2) == 4 && list.get(5) == null && list.size() == 4;
        Assertions.assertTrue(result);
    }

    @Test
    public void removeAllElementsInPopulatedList() {
        for(int i = 0; i < 5; i++) {
            list.add(i + 1);
        }
        for(int i = 0; i < 5; i++) {
            list.remove(i + 1);
        }
        var result = list.isEmpty() && list.size() == 0;
        Assertions.assertTrue(result);
    }

    @Test
    public void removeAllElementsThenAddMultipleElements() {
        for(int i = 0; i < 5; i++) {
            list.add(i + 1);
        }
        for(int i = 0; i < 5; i++) {
            list.remove(i + 1);
        }
        for(int i = 0; i < 5; i++) {
            list.add(i + 1);
        }
        var result = list.size() == 5 && !list.isEmpty();
        Assertions.assertTrue(result);
    }

    @Test
    public void removeNullElement() {
        var result = list.remove(null);
        Assertions.assertFalse(result);
    }

    @Test
    public void removeInvalidElement() {
        var result = list.remove(1);
        Assertions.assertFalse(result);
    }

    @Test
    public void getLastElementAfterIndexShifting() {
        for(int i = 0; i < 5; i++) {
            list.add(i + 1);
        }
        for(int i = 0; i < 4; i++) {
            list.remove(i + 1);
        }
        var result = list.get(0);
        Assertions.assertEquals(5, result);
    }

    @Test
    public void getFirstElementAfterIndexShifting() {
        for(int i = 0; i < 5; i++) {
            list.add(i + 1);
        }
        for(int i = 1; i < 5; i++) {
            list.remove(i + 1);
        }
        var result = list.get(0);
        Assertions.assertEquals(1, result);
    }

    @Test
    public void getMiddleElementAfterIndexShifting() {
        for(int i = 0; i < 5; i++) {
            list.add(i + 1);
        }
        for(int i = 0; i < 5; i++) {
            if(i == 2) {
                continue;
            }
            list.remove(i + 1);
        }
        var result = list.get(0);
        Assertions.assertEquals(3, result);
    }

    @Test
    public void getInvalidElement() {
        var result = list.get(1);
        Assertions.assertNull(result);
    }

    @Test
    public void clearPopulatedArray() {
        for(int i = 0; i < 10; i++) {
            list.add(i + 1);
        }
        list.clear();
        var result = list.size() == 0 && list.isEmpty();
        Assertions.assertTrue(result);
    }

    @Test
    public void getIndexOfFrontElement() {
        for(int i = 0; i < 10; i++) {
            list.add(i + 1);
        }
        var result = list.indexOf(1);
        Assertions.assertEquals(0, result);
    }

    @Test
    public void getIndexOfRearElement() {
        for(int i = 0; i < 10; i++) {
            list.add(i + 1);
        }
        var result = list.indexOf(5);
        Assertions.assertEquals(4, result);
    }

    @Test
    public void getIndexOfMiddleElement() {
        for(int i = 0; i < 10; i++) {
            list.add(i + 1);
        }
        var result = list.indexOf(3);
        Assertions.assertEquals(2, result);
    }

    @Test
    public void getIndexInvalidElement() {
        var result = list.indexOf(1);
        Assertions.assertEquals(-1, result);
    }

    @Test
    public void getIndexOfNullElement() {
        var result = list.indexOf(null);
        Assertions.assertEquals(-1, result);
    }

    @Test
    public void getIndexOfElementAfterSeveralDeletions() {
        for(int i = 0; i < 10; i++) {
            list.add(i + 1);
        }
        for(int i = 0; i < 5; i++) {
            list.remove(i + 1);
        }
        var result = list.indexOf(6);
        Assertions.assertEquals(0, result);
    }

    @Test
    public void getFirstIndexOfElementWithMultipleOccurences() {
        for(int i = 0; i < 10; i++) {
            list.add(1);
        }
        var result = list.indexOf(1);
        Assertions.assertEquals(0, result);
    }

    @Test
    public void getLastIndexOfFrontElement() {
        for(int i = 0; i < 10; i++) {
            list.add(i + 1);
        }
        var result = list.lastIndexOf(1);
        Assertions.assertEquals(0, result);
    }

    @Test
    public void getLastIndexOfRearElement() {
        for(int i = 0; i < 10; i++) {
            list.add(i + 1);
        }
        var result = list.lastIndexOf(5);
        Assertions.assertEquals(4, result);
    }

    @Test
    public void getLastIndexOfMiddleElement() {
        for(int i = 0; i < 10; i++) {
            list.add(i + 1);
        }
        var result = list.lastIndexOf(3);
        Assertions.assertEquals(2, result);
    }

    @Test
    public void getLastIndexInvalidElement() {
        var result = list.lastIndexOf(1);
        Assertions.assertEquals(-1, result);
    }

    @Test
    public void getLastIndexOfNullElement() {
        var result = list.lastIndexOf(null);
        Assertions.assertEquals(-1, result);
    }

    @Test
    public void getLastIndexOfElementAfterSeveralDeletions() {
        for(int i = 0; i < 10; i++) {
            list.add(i + 1);
        }
        for(int i = 0; i < 5; i++) {
            list.remove(i + 1);
        }
        var result = list.lastIndexOf(6);
        Assertions.assertEquals(0, result);
    }

    @Test
    public void getLastIndexOfElementWithMultipleOccurrences() {
        for(int i = 0; i < 10; i++) {
            list.add(1);
        }
        var result = list.lastIndexOf(1);
        Assertions.assertEquals(9, result);
    }

    @Test
    public void setNegativeIndex() {
        var result = list.set(-1, 1);
        Assertions.assertFalse(result);
    }

    @Test
    public void setInvalidIndex() {
        var result = list.set(0, 1);
        Assertions.assertFalse(result);
    }

    @Test
    public void setValidIndex() {
        list.add(1);
        list.set(0, 2);
        var result = list.contains(2) && !list.contains(1) && list.get(0) == 2;
        Assertions.assertTrue(result);
    }

    @Test
    public void getElementsAsString() {
        for(int i = 0; i < 5; i++) {
            list.add(i + 1);
        }
        var result = list.toString();
        Assertions.assertEquals("[1 2 3 4 5]", result);
    }

    @Test
    public void getElementsAsStringFromEmptyList() {
        var result = list.toString();
        Assertions.assertEquals("[]", result);
    }
}
