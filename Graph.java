package bayes;

import java.util.ArrayList;

 /**
  * ������Ҫ����ͼ���㷨�����涨����ͼ��һЩ�ڱ����ݳ�Ա
  * ͬʱ����ʵ���������õ���ͼ���㷨������ӱߣ����ߣ���·����������
  * @author tang
  * @Time 2014-06-01
  */

public class Graph {
	
	/*˵��������Ϊ�˷���ֱ����ʾ�Ӷ������־���������ýڵ����洢ͼ����������������*/
	private int g_matrix[][];//�ڽӾ������ڴ洢ͼ��
	private int digraph_matrix[][];//�洢����ͼ���ڽӾ���
	private boolean[] hasFlag;
	private int ver_cnt;//����ڵ��������
	private static int INF=Integer.MAX_VALUE;//���ֵ��ʾ�ڵ�֮�䲻�ɴ
	private ArrayList<String> res=new ArrayList<String>();//�������е�·���Ľ����ÿһ��·���ĸ�ʽ���磺0->2->1->3:7
	
    /**
     * �÷����ǹ��캯������Ҫʵ�ֵľ���
     * ��ͼ�ĳ�ʼ����
     * @param vertex_count �ڵ�ĸ���
     * @author tang
     * @Time 2014-06-01
     */
    
	public Graph(int vertex_count){
		this.ver_cnt=vertex_count;
		g_matrix=new int[vertex_count][vertex_count];
		digraph_matrix=new int[vertex_count][vertex_count];
		hasFlag=new boolean[ver_cnt];
		for(int i=0;i<vertex_count;++i){//��ʼ���ڽӾ���
			for(int j=0;j<vertex_count;++j){
				g_matrix[i][j]=INF;//��ʾ�ڵ�֮�䲻�ɴ
				digraph_matrix[i][j]=0;
			}
		}
		
	}
	
	/**
	 * �÷����Ĺ��ܾ��ǻ�ȡ�ڵ���
	 * @return ͼ�нڵ�ĸ���
	 * @author tang
	 * @Time 2014-06-01
	 */
	
	public int get_vertex_count(){
		return ver_cnt;
	}
	
	/**
	 * �÷���������ͼ�мӱ�
	 * @param m ��ʼ�ڵ��
	 * @param n �����ڵ��
	 * @author tang
	 * @Time 2014-06-01
	 */
	
	public void add_edge(int m,int n){
		g_matrix[m][n]=1;
		g_matrix[n][m]=1;
	}
	
	/**
	 * �÷�������������ͼ�ӱ�
	 * @param m ��ʼ�ڵ��
	 * @param n �����ڵ��
	 * @author tang
	 * @Time 2014-06-01
	 */
	
	public void add_edge1(int m,int n){
		digraph_matrix[m][n]=1;
	}
	
	/**
	 * �÷�������ɾ��һ����
	 * @param m ��ʼ�ڵ��
	 * @param n �����ڵ��
	 * @author tang
	 * @Time 2014-06-01
	 */
	
	public void delete_edge(int m,int n){
		digraph_matrix[m][n]=0;
	}
	
	/**
	 * �÷������Ǵ�ӡͼ�ĺ���
	 * @author tang
	 * @Time 2014-06-01
	 */
	
	public void print_graph(){
		for(int i=0;i<ver_cnt;i++){
			System.out.println();
			for(int j=0;j<ver_cnt;j++){
				if(g_matrix[i][j]==INF)
				    System.out.print("��"+" ");
				else
					System.out.print(g_matrix[i][j]+" ");
			}
		}
	}
	
	/**
	 * �÷������Ǵ�ӡ����ͼ
	 * @author tang
	 * @Time 2014-06-01
	 */
	
	public void print_digraph(){
		for(int i=0;i<ver_cnt;i++){
			System.out.println();
			for(int j=0;j<ver_cnt;j++){
				System.out.print(digraph_matrix[i][j]+" ");
			}
		}
	}
	
	/**
	 * �÷���ʵ�ֵľ����ж������ڵ�֮���Ƿ���ڿ���·��
	 * Ҫ�õ�Find_path�ļ��к���
	 * @param begin ��ʼ�ڵ��
	 * @param end �����ڵ��
	 * @return ��/��
	 * @author tang
	 * @Time 2014-06-01
	 */
	
	public boolean is_path(int begin,int end){

		Find_path find_path=new Find_path(ver_cnt);
		if(find_path.get_dist(begin, end, g_matrix)!=INF){
			return true;
		}else
			return false;
	}
	
	/**
	 * �÷������ǻ�ȡĳ���ڵ���Ⱥ���
	 * @param n �ڵ��
	 * @return �����
	 * @author tang
	 * @Time 2014-06-01
	 */
	
	public int inDegree(Node n){  
        int indegree=0;
        int k;
        k=n.get_node_num();
        for(int i=0;i<ver_cnt;++i)
        	indegree+=digraph_matrix[i][k];
        return indegree;
	}  
	
	/**
	 * ������Ⱥ������ڵ����
	 * @param k �ڵ��
	 * @return ���
	 * @author tang
	 * @Time 2014-06-20
	 */
	
	public int inDegree(int k){
		int indegree=0;
		for(int i=0;i<digraph_matrix.length;++i)
			indegree+=digraph_matrix[i][k];
		return indegree;
	}
	
	/**
	 * ���ĳ���ڵ�ĳ���
	 * @param k�ڵ�ı��
	 * @return �ڵ�ĳ��ȵ�ֵ
	 * @author tang
	 * @Time 2014-06-20
	 */
	public int outDegree(int k){
		int outdegree=0;
		for(int i=0;i<digraph_matrix.length;++i){
			outdegree+=digraph_matrix[k][i];
		}
		return outdegree;
	}
	
	/**
	 * �÷������ǻ�ȡ�����ڵ�֮��ıߵ���ֵ
	 * �����0��û�б䣬�����1���б�
	 * @param i �ڵ��
	 * @param j �ڵ��
	 * @return �ڵ�֮�����ֵ
	 * @author tang
	 * @Time 2014-06-01
	 */
	
	public int get_matrix_value(int i,int j) {
		return digraph_matrix[i][j];
	}
	
	/**
	 * �÷������ǻ�ȡ���������ڵ�֮���·��	
	 * @param sԴ�ڵ�
	 * @param dĿ�Ľڵ�
	 * @author tang
	 * @Time 2014-06-01
	 */
	
	public void getPaths(int s,int d,String path)
	{
		 hasFlag[s]=true;//Դ���ѷ��ʹ�. 
	     for(int i=0;i<ver_cnt;i++){
		   if (digraph_matrix[s][i]==0 || hasFlag[i]){//����·��ͨ���ѷ��ʹ���������һ����㡣
			continue;
		 }

		 if(i==d){//�����ҵ�һ��·�� 
			res.add(path+"->"+d);//��������
			//System.out.print("path="+path+" d="+d+"\n");
		    continue;
		  }
		 getPaths(i, d, path+"-"+i);//������
		 hasFlag[i]=false;		
	   }
	}
	
	/**
	 * ��ȡ��һ��������������·���ĺ���
	 * @param n�ڵ��
	 */
	public void get_node_path(Node n){
		//char cha=(char)(n.get_node_num()+'0');
		String ch = String.valueOf(n.get_node_num());
		ArrayList<String> tmp_lst=new ArrayList<String>();
	    ArrayList<String> res_lst=new ArrayList<String>();
		String str;
		  for(int i=0;i<digraph_matrix.length;++i){
			  if(inDegree(i)==0){
				  for(int j=0;j<digraph_matrix.length;++j){
					if(j!=i && outDegree(j)==0){
						str=String.valueOf(i);
						getPaths(i,j,str);
						//System.out.print(" "+res);
						if(!res.isEmpty()){
							
							for(String e:res){
								res_lst.add(e);
							}
						}
						res.clear();//��res���
					}
				  }
			  }
		    }
		  int flag=0;
		  for(int i=0;i<res_lst.size();++i){
			  //System.out.print(res_lst.get(i));
              String term = res_lst.get(i);
              term = term.replace("->", ",");
              term = term.replace("-", ",");

              //term=term.replace(' ', ',');
             // System.out.println("   "+term);
  
              String[] data = term.split(",");
              //System.out.println(">>>>>>>>>> "+data.length);
              if(data.length!=0){
            	  for(int ii=0;ii<data.length;ii++){
            		  //System.out.println(data[ii]+"----"+ch);
            		  if(data[ii].equals(ch)){flag=1;}//System.out.println(">>>>>>>>>> ");}
            	  }
              }
			  if(flag==1){
				  tmp_lst.add(res_lst.get(i));
			  }
			  flag = 0;
		  }
		  for(int i=0;i<tmp_lst.size();++i){
			  System.out.print(tmp_lst.get(i)+" ");
		  }
	}
	


	/**
	 * �÷����Ǵ�ӡ·��
	 * @author tang
	 * @Time 2014-06-01
	 */
	
	public void print_path(){
		System.out.print("·���Ľڵ���:");
		for(int i=0;i<res.size();++i)
			System.out.print(res.get(i)+" ");
	}
}
