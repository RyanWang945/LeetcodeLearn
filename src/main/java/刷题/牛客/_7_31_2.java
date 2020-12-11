package 刷题.牛客;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author Ryan
 * @date 2020/7/31 20:29
 *
 */
public class _7_31_2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        char[][] matrix=new char[n][n];
        for(int i=0;i<n;i++){
            matrix[i]=sc.next().toCharArray();
            sc.nextLine();
        }
        int[][] direction=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        int[][] step=new int[n][n];
        Queue<int[]> queue=new LinkedList<>();
        boolean f=false;
        int result=-1;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(f) break;
                if(matrix[i][j]=='S'){
                    queue.offer(new int[]{i,j});
                    step[i][j]=0;
                    while(!queue.isEmpty()){
                        int[] poll = queue.poll();
                        for(int d=0;d<4;d++){
                            int newX=poll[0]+direction[d][0];
                            int newY=poll[1]+direction[d][1];
                            if(newX>=0&&newX<n&&newY>=0&&newY<n&&matrix[newX][newY]!='#'){
                                if(matrix[newX][newY]=='E'){
                                    f=true;
                                    result=step[poll[0]][poll[1]]+1;
                                    break;
                                }
                                step[newX][newY]=step[poll[0]][poll[1]]+1;
                                matrix[newX][newY]='#';
                                queue.offer(new int[]{newX,newY});
                            }else if(newX==-1&&matrix[n-1][newY]!='#'){
                                if(matrix[n-1][newY]=='E'){
                                    result=step[poll[0]][poll[1]]+1;
                                    f=true;
                                    break;
                                }
                                step[n-1][newY]=step[poll[0]][poll[1]]+1;
                                matrix[n-1][newY]='#';
                                queue.offer(new int[]{n-1,newY});
                            }else if(newY==-1&&matrix[newX][n-1]!='#') {
                                if(matrix[newX][n-1]=='E'){
                                    result=step[poll[0]][poll[1]]+1;
                                    f=true;
                                    break;
                                }
                                step[newX][n - 1] = step[poll[0]][poll[1]] + 1;
                                matrix[newX][n - 1] ='#';
                                queue.offer(new int[]{newX,n-1});
                            }else if(newX==n&&matrix[0][newY]!='#'){
                                result=step[poll[0]][poll[1]]+1;
                                if(matrix[0][newY]=='E'){
                                    f=true;
                                    break;
                                }
                                step[0][newY]=step[poll[0]][poll[1]] + 1;
                                matrix[0][newY]='#';
                                queue.offer(new int[]{0,newY});
                            }else if(newY==n&&matrix[newX][0]!='#'){
                                result=step[poll[0]][poll[1]]+1;
                                if(matrix[newX][0]=='E'){
                                    f=true;
                                    break;
                                }
                                step[newX][0]=step[poll[0]][poll[1]] + 1;
                                matrix[newX][0]='#';
                                queue.offer(new int[]{newX,0});
                            }

                        }
                        if(f)
                            break;
                    }
                }
            }
        }
        System.out.println(result);
    }
}
