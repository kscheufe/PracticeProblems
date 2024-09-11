class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            for (int j = 0; j < n; j++)
                {
                    nums1[j] = nums2[j];
                }
                return;
        }
        for (int i = nums1.length-1; i >= 0; i--)
        {
            if (n == 0) {
                System.out.println("s");
                return;}
            if (m == 0) {
                for (int j = 0; j < n; j++)
                {
                    nums1[j] = nums2[j];
                }
                return;
            }
            if (nums1[m-1] > nums2[n-1])
            {
                nums1[i] = nums1[m-1];
                m--;
            }
            else {
                nums1[i] = nums2[n-1];
                n--;
            }
        }

    }
}