package bayes;

import java.util.ArrayList;
import java.util.Scanner;

public class Relation_table{

	/**
	 * ������Ҫ�Ƕ����ϵ��Ļ������ݳ�Ա��
	 * ��Ҫ�ĳ�Ա����
	 * @author Don King
	 * @Time 2014-06-07
	 */
	
	private int relation_count=0;//��ϵ��������
	private Relation rel;
    private ArrayList<Relation> relation_list;
    private int rand_num1[][]=new int[100][100];
    private int rand_num2[][]=new int[100][100];
    
    /**
     * �÷����ǹ��캯�������ǶԹ�ϵ����г�ʼ��		
     * @param n ����
     * @param m ����
     * @param k ����
     * @param fea_rel_count1 ������ϵ����
     * @author tang
     * @Time 2014-06-07
     */
    
    public Relation_table(int n[],int m[],int k,int fea_count1[],int fea_rel_count1[],int rand1){ 
    	
    	
	    for(int i=0;i<rand1;i++){    //System.out.println("-----fea_rel_count1------->"+fea_rel_count1[i]);
	    	for(int j=0;j<fea_rel_count1[i];j++){	    
	    		//System.out.println("------fea_count1------>"+fea_rel_count1[i]);
	    		rand_num1[i][j]=(int)(Math.random()*(fea_count1[n[i]]-1));
	    		rand_num2[i][j]=(int)(Math.random()*(fea_count1[m[i]]-1));
	    	}
	    }
	    System.out.println();
    	
/*    	Scanner input=new Scanner(System.in);//����һ������ɨ�������
		System.out.println("��������������rand_num1["+rand1+"][],ÿ�鲻ͬ:");
		for(int i=0;i<rand1;i++){    
			for(int j=0;j<fea_rel_count1[i];j++){	    
				rand_num1[i][j]=input.nextInt();
			}
    	}	
		System.out.println("��������������rand_num2["+rand1+"][],ÿ�鲻ͬ:");
		for(int i=0;i<rand1;i++){    
			for(int j=0;j<fea_rel_count1[i];j++){	    
				rand_num2[i][j]=input.nextInt();
			}
    	}*/
    	
	    
	   	    
	    System.out.println("\n\nrandom���ֵ��");
	    for(int i=0;i<rand1;i++){for(int j=0;j<fea_rel_count1[i];j++){System.out.print(rand_num1[i][j]+" ");}System.out.println();}
	    System.out.println("----------------");
	    for(int i=0;i<rand1;i++){for(int j=0;j<fea_rel_count1[i];j++){System.out.print(rand_num2[i][j]+" ");}System.out.println();}
	    System.out.println("\n\n ");
    	/*
       {{0,0,0,1,1,1},
            {0,1,1,2,2},
            {0,1,2,3,4},
            {0,1,2,1,0},
            {1,3},
            {1,5},
            {0,1,2,3,4,5,4,1},
            {0,1,2,3,4,5,6,4,2},
            {0,1,2,3,2,1,0},
            {4,4}};
       {{0,1,2,0,1,2},
            {3,4,5,4,5},
            {0,1,2,3,1},
            {0,1,2,3,4},
            {4,6},
            {1,5},
            {0,1,2,2,1,0,2,0},
            {0,1,2,3,4,5,6,4,1},
            {0,1,2,3,4,3,2},
            {1,2}};*/
    	relation_list=new ArrayList<Relation>();
    	for(int i=0;i<k;++i){
    		this.relation_count+=fea_rel_count1[i];
            for(int j=0;j<fea_rel_count1[i];++j){
        		rel=new Relation(n[i],m[i],rand_num1[i][j],rand_num2[i][j]);
        		relation_list.add(rel);
            }
    	}
    }
    
    /**
     * �÷����Ǵ�ӡ��ϵ��ĺ���
     * @author tang
     * @Time 2014-06-07
     */
    
    public void print_relation(){
    	System.out.println("������Ĺ�ϵ��:");
    	for(int i=0;i<relation_list.size();++i){
    		if(i!=0&&i%3==0)
    			System.out.println();
    		relation_list.get(i).print_rel(); 			
    	}
    }
   
    /**
     * ��ȡ��ϵ����ĺ���
     * @return ��ϵ����
     * @author tang
     * @Time 2014-06-07
     */
    
    public ArrayList<Relation> get_relation_list(){
    	return relation_list;
    }
    
    /**
     * �÷����ǻ�ȡ��ϵ�����ĺ���
     * @return ��ϵ������
     * @author tang
     * @Time 2014-06-07
     */
    public int get_rel_count(){
    	return relation_count;
    }
}
