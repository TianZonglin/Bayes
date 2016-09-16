package bayes;
import java.util.ArrayList;
import java.util.List;
	
    /**
	 * ͼ  �ڽӾ���  ����·��  ���������㷨
	 * ������Ҫʵ�ֵ��ǻ�ȡ·���Ĺ��ܣ���Ҫ�õ����㷨�Ǹ��������㷨��һЩ������С����
	 * @author tang
	 * @Time 2014-05-26
	 */

public class Find_path {
	private static int INF=Integer.MAX_VALUE;
         //dist[i][j]=INF<==>no edges between i and j
	private int[][] dist;
         //the distance between i and j.At first,dist[i][j] is the weight of edge [i,j]  
	private int[][] path;  
	private List<Integer> result=new ArrayList<Integer>();
	
	/**
	 * ���캯��������·������
	 * @param size ���󳤶�
	 * @author tang
	 * @Time 2014-05-26
	 */
	
	public Find_path(int size){
		this.path=new int[size][size];
		this.dist=new int[size][size];
	}

	/**
	 * �÷������ҵ����·����ʹ���˸������º���
	 * @param begin ��ʼ�ڵ�
	 * @param end   �����ڵ�
	 * @param matrix ����
	 * @author tang
	 * @Time 2014-05-27
	 */
	
	public  void findCheapestPath(int begin,int end,int[][] matrix){
		floyd(matrix);
		result.add(begin);
		findPath(begin,end);
		result.add(end);
	}
	
	/**
	 * �÷�������Ҫ���ܾ��ǻ�ȡ����·���ĺ���
	 * @param i �ڵ��
	 * @param j �ڵ��
	 * @author tang
	 * @Time 2014-05-27
	 */
	
	public void findPath(int i,int j){
		int k=path[i][j];
		if(k==-1)return;
		findPath(i,k);
		result.add(k);
		findPath(k,j);
	}
	
	/**
	 * �÷����Ǹ��������㷨�����Ĵ����������forѭ��
	 * @param matrix ͼ����
	 * @author tang
	 * @Time 2014-05-27
	 */
	
	public  void floyd(int[][] matrix){
		int size=matrix.length;
		//initialize dist and path
		for(int i=0;i<size;i++){
			for(int j=0;j<size;j++){
				path[i][j]=-1;
				dist[i][j]=matrix[i][j];
			}
		}
		for(int k=0;k<size;k++){
			for(int i=0;i<size;i++){
				for(int j=0;j<size;j++){
					if(dist[i][k]!=INF&& dist[k][j]!=INF&&dist[i][k]+dist[k][j]<dist[i][j]){//dist[i][k]+dist[k][j]>dist[i][j]-->longestPath
						dist[i][j]=dist[i][k]+dist[k][j];
						path[i][j]=k;
					}
				}
			}
		}
		
	}

	/**
	 * �÷�����ȡһ������ġ�����������������������
	 * @param begin ��ʼ�ڵ�
	 * @param end   �����ڵ�
	 * @param matrix1 �ڽӾ���
	 * @return һ������
	 * @author tang
	 * @Time 2014-05-27
	 */
	
	public int get_dist(int begin, int end,int[][] matrix1) {
		// TODO Auto-generated method stub
		System.out.println("@get_dist@-> "+begin+"  "+end);
		findCheapestPath(begin,end,matrix1);
		return this.dist[begin][end];
	}
}
