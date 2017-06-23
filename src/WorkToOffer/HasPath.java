package WorkToOffer;

/**
 * Created by zhuhao on 17-6-23.
 */
public class HasPath {
    int pathLength = 0;
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        if (!isLegalIpput ( matrix,rows,cols,str ))
            return false;

        boolean[] visited = new boolean[rows*cols];
        for (int row=0;row<rows;row++){
            for (int col=0;col<cols;col++){
                if (hasPathCore ( matrix,rows,cols,row,col,str,pathLength,visited ))
                    return true;
            }
        }
        return false;
    }

    public boolean hasPathCore(char[] matrix,int rows,int cols,int row,
                              int col,char[] str,int pathLenth,boolean[] visited){
        if (pathLenth == str.length)
            return true;

        boolean haPath = false;
        if (row>=0 && row<rows && col>=0 && col<cols
                && matrix[row*cols + col] == str[pathLenth]
                && !visited[row*cols + col]){
            pathLenth ++;
            visited[row*cols + col] = true;

            haPath = hasPathCore ( matrix, rows, cols, row-1, col, str, pathLenth, visited )
                    || hasPathCore ( matrix, rows, cols, row, col-1, str, pathLenth, visited )
                    || hasPathCore ( matrix, rows, cols, row+1, col, str, pathLenth, visited )
                    || hasPathCore ( matrix, rows, cols, row, col+1, str, pathLenth, visited );

            if (!haPath){
                pathLenth -- ;
                visited[row*cols + col] = false;
            }
        }

        return haPath;
    }

    public boolean isLegalIpput(char[] matrix,int rows,int cols,char[] str){
        if (matrix == null || str == null || matrix.length==0 || str.length ==0)
            return false;
        if (rows<1 || cols<1)
            return false;

        return true;
    }
}
