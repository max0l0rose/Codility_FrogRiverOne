
Не сходится задание

public class Solution {

    public int solution(int X, int[] A) {
        //Arrays.sort(A);
        //List<Integer> list = Arrays.stream(A).sorted().distinct().boxed().collect(Collectors.toList());

        int xmax = 0;
        for (int i = 0; i <= X; i++)
            if (i<A.length) {
                if (xmax < A[i])
                    xmax = A[i];
            }

        int[] B = new int[xmax];

//        if (X > xmax-1)
//            return -1;

        if (X > A.length-1)
            X = A.length-1;

        for (int j = 0; j <= X; j++) {
            int ind = A[j] - 1;
            B[ind] =1;
        }

        int hole = -1;

        for (int j = 0; j < B.length; j++)
            if (B[j] == 0) {
                hole = j;
                break;
            }

        if (hole<0)
            return X;

        for (int i = X+1; i < A.length; i++) {

            if (A[i] == hole+1) {
                B[hole] = 1;
                hole = -1;
                for (int j = 0; j < B.length; j++)
                    if (B[j] == 0) {
                        hole = j;
                        break;
                    }
                if (hole<0)
                    return i;
            }

            int bi = A[i];
            if (bi<=B.length)
                B[bi-1] = 1;
        }

        return -1;
    }
}


