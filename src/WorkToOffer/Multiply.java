package WorkToOffer;

/**
 * Created by zhuhao on 17-6-19.
 * 把B[i]以i为分界分解成C[i]和D[i]
 * 其中C[i]=A[0]*A[1]*...*A[i-1]
 * D[i]=A[i+1]*A[i+2]*...*A[n-1]
 */
public class Multiply {
    public int[] multiply(int[] A) {
        if (A==null)
            return null;
        int length = A.length;
        int[] B = new int[length];
        int[] C = new int[length];
        int[] D = new int[length];
        if (length == 0)
            return B;

        C[0] =1;
        for (int i=1;i<length;i++)
             C[i] = C[i-1]*A[i-1];
        D[length-1] = 1;
        for (int i=length-2;i>=0;i--)
            D[i] = D[i+1]*A[i+1];
        for (int i=0;i<length;i++)
            B[i] = C[i] * D[i];
        return B;
    }
}
