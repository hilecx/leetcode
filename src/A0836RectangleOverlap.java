public class A0836RectangleOverlap {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int[] rec1s = change(rec1);
        int[] rec2s = change(rec2);
        return f(rec1, rec2) || f(rec2, rec1) || f(rec1s, rec2s) || f(rec2s, rec1s);
    }

    private boolean f(int[] a, int[] b) {
        return a[0] < b[2] && a[1] < b[3] && a[2] > b[0] && a[3] > b[1];
    }

    private int[] change(int[] r) {
        int[] rs = new int[4];
        rs[0] = r[0];
        rs[1] = r[3];
        rs[2] = r[1];
        rs[4] = r[2];
        return rs;
    }

    //The answer for whether they don't overlap is LEFT OR RIGHT OR UP OR DOWN,
    // where OR is the logical OR, and LEFT is a boolean that represents whether rec1 is to the left of rec2.
    // The answer for whether they do overlap is the negation of this.
    public boolean isRectangleOverlap2(int[] rec1, int[] rec2) {
        return !(rec1[2] <= rec2[0] ||   // left
                rec1[3] <= rec2[1] ||   // bottom
                rec1[0] >= rec2[2] ||   // right
                rec1[1] >= rec2[3]);    // top
    }

    public boolean isRectangleOverlap3(int[] rec1, int[] rec2) {
        return rec1[2] > rec2[0] &&   // left
                rec1[3] > rec2[1] &&   // bottom
                rec1[0] < rec2[2] &&   // right
                rec1[1] < rec2[3];     // top
    }
}
