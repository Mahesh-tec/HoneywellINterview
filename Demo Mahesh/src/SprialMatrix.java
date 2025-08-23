import java.util.*;
public class SprialMatrix {

        public static void main(String[] args) {
            int[][] mat = {
                    {1, 2, 3, 4},
                    {5, 6, 7, 8},
                    {9, 10, 11, 12},
                    {13, 14, 15, 16}
            };

            List<Integer> spiralOrder = new ArrayList<>();
            int top = 0, bottom = mat.length - 1;
            int left = 0, right = mat[0].length - 1;

            while (top <= bottom && left <= right) {
                // left to right
                for (int i = left; i <= right; i++)
                    spiralOrder.add(mat[top][i]);
                top++;

                // top to bottom
                for (int i = top; i <= bottom; i++)
                    spiralOrder.add(mat[i][right]);
                right--;

                // right to left
                if (top <= bottom) {
                    for (int i = right; i >= left; i--)
                        spiralOrder.add(mat[bottom][i]);
                    bottom--;
                }

                // bottom to top
                if (left <= right) {
                    for (int i = bottom; i >= top; i--)
                        spiralOrder.add(mat[i][left]);
                    left++;
                }
            }

            System.out.println(spiralOrder);
        }
    }



