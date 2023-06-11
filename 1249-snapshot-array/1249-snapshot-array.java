// binary Search
// For every index maintain a list of SnapID and values i.e history

class SnapshotArray {
    int snapId;
    List<List<int[]>> histories;

    public SnapshotArray(int length) {
        histories = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            histories.add(new ArrayList<>());
            histories.get(i).add(new int[] { -1, 0 });
        }
        snapId = 0;
    }

    // sets the element at a given index to val
    public void set(int index, int val) {
        histories.get(index).add(new int[] { snapId, val });
    }

    // takes a snapshot of the array and returns the snap_id: the total number of times we called snap() minus 1
    public int snap() {
        snapId++;
        return snapId - 1;
    }

    //  It should be noted that snap_id may not be present in the record list. Therefore, we can use binary search to find the record with the highest snapshot ID that is less than or equal to the given snap_id
    public int get(int index, int snap_id) {
        List<int[]> history = histories.get(index);
        // for (int i = 0; i < history.size(); i++) {
        //     System.out.println(history.get(i)[0] + " . " + history.get(i)[1]);
        // }

        int left = 0;
        int right = history.size() - 1;
        int pos = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            // most recent snapId value
            if (history.get(mid)[0] <= snap_id) {
                left = mid + 1;
                pos = mid;
            } else {
                right = mid - 1;
            }
        }
        return history.get(pos)[1];
    }
}
/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */
