/**
*作者: Bo-Wen Duan (Paul)
*聯絡方式: bowenduan618@gmail.com
*修改日期: 2016 / 1 / 12
*/
package KmeansClusteringMain;
public class KMeansEval {
	public static void main(String[] args) {
		double[][] test_data = { 
                {5.1,3.5,1.4,0.2},
                {4.9,3.0,1.4,0.2},
                {4.7,3.2,1.3,0.2},
                {4.6,3.1,1.5,0.2},
                {5.0,3.6,1.4,0.2},
                {5.4,3.9,1.7,0.4},
                {4.6,3.4,1.4,0.3},
                {5.0,3.4,1.5,0.2},
                {4.4,2.9,1.4,0.2},
                {4.9,3.1,1.5,0.1},
                {5.4,3.7,1.5,0.2},
                {4.8,3.4,1.6,0.2},
                {4.8,3.0,1.4,0.1},
                {4.3,3.0,1.1,0.1},
                {5.8,4.0,1.2,0.2},
                {5.7,4.4,1.5,0.4},
                {5.4,3.9,1.3,0.4},
                {5.1,3.5,1.4,0.3},
                {5.7,3.8,1.7,0.3},
                {5.1,3.8,1.5,0.3},
                {5.4,3.4,1.7,0.2},
                {5.1,3.7,1.5,0.4},
                {4.6,3.6,1.0,0.2},
                {5.1,3.3,1.7,0.5},
                {4.8,3.4,1.9,0.2},
                {5.0,3.0,1.6,0.2},
                {5.0,3.4,1.6,0.4},
                {5.2,3.5,1.5,0.2},
                {5.2,3.4,1.4,0.2},
                {4.7,3.2,1.6,0.2},
                {4.8,3.1,1.6,0.2},
                {5.4,3.4,1.5,0.4},
                {5.2,4.1,1.5,0.1},
                {5.5,4.2,1.4,0.2},
                {4.9,3.1,1.5,0.1},
                {5.0,3.2,1.2,0.2},
                {5.5,3.5,1.3,0.2},
                {4.9,3.1,1.5,0.1},
                {4.4,3.0,1.3,0.2},
                {5.1,3.4,1.5,0.2},
                {5.0,3.5,1.3,0.3},
                {4.5,2.3,1.3,0.3},
                {4.4,3.2,1.3,0.2},
                {5.0,3.5,1.6,0.6},
                {5.1,3.8,1.9,0.4},
                {4.8,3.0,1.4,0.3},
                {5.1,3.8,1.6,0.2},
                {4.6,3.2,1.4,0.2},
                {5.3,3.7,1.5,0.2},
                {5.0,3.3,1.4,0.2},
                {7.0,3.2,4.7,1.4},
                {6.4,3.2,4.5,1.5},
                {6.9,3.1,4.9,1.5},
                {5.5,2.3,4.0,1.3},
                {6.5,2.8,4.6,1.5},
                {5.7,2.8,4.5,1.3},
                {6.3,3.3,4.7,1.6},
                {4.9,2.4,3.3,1.0},
                {6.6,2.9,4.6,1.3},
                {5.2,2.7,3.9,1.4},
                {5.0,2.0,3.5,1.0},
                {5.9,3.0,4.2,1.5},
                {6.0,2.2,4.0,1.0},
                {6.1,2.9,4.7,1.4},
                {5.6,2.9,3.6,1.3},
                {6.7,3.1,4.4,1.4},
                {5.6,3.0,4.5,1.5},
                {5.8,2.7,4.1,1.0},
                {6.2,2.2,4.5,1.5},
                {5.6,2.5,3.9,1.1},
                {5.9,3.2,4.8,1.8},
                {6.1,2.8,4.0,1.3},
                {6.3,2.5,4.9,1.5},
                {6.1,2.8,4.7,1.2},
                {6.4,2.9,4.3,1.3},
                {6.6,3.0,4.4,1.4},
                {6.8,2.8,4.8,1.4},
                {6.7,3.0,5.0,1.7},
                {6.0,2.9,4.5,1.5},
                {5.7,2.6,3.5,1.0},
                {5.5,2.4,3.8,1.1},
                {5.5,2.4,3.7,1.0},
                {5.8,2.7,3.9,1.2},
                {6.0,2.7,5.1,1.6},
                {5.4,3.0,4.5,1.5},
                {6.0,3.4,4.5,1.6},
                {6.7,3.1,4.7,1.5},
                {6.3,2.3,4.4,1.3},
                {5.6,3.0,4.1,1.3},
                {5.5,2.5,4.0,1.3},
                {5.5,2.6,4.4,1.2},
                {6.1,3.0,4.6,1.4},
                {5.8,2.6,4.0,1.2},
                {5.0,2.3,3.3,1.0},
                {5.6,2.7,4.2,1.3},
                {5.7,3.0,4.2,1.2},
                {5.7,2.9,4.2,1.3},
                {6.2,2.9,4.3,1.3},
                {5.1,2.5,3.0,1.1},
                {5.7,2.8,4.1,1.3},
                {6.3,3.3,6.0,2.5},
                {5.8,2.7,5.1,1.9},
                {7.1,3.0,5.9,2.1},
                {6.3,2.9,5.6,1.8},
                {6.5,3.0,5.8,2.2},
                {7.6,3.0,6.6,2.1},
                {4.9,2.5,4.5,1.7},
                {7.3,2.9,6.3,1.8},
                {6.7,2.5,5.8,1.8},
                {7.2,3.6,6.1,2.5},
                {6.5,3.2,5.1,2.0},
                {6.4,2.7,5.3,1.9},
                {6.8,3.0,5.5,2.1},
                {5.7,2.5,5.0,2.0},
                {5.8,2.8,5.1,2.4},
                {6.4,3.2,5.3,2.3},
                {6.5,3.0,5.5,1.8},
                {7.7,3.8,6.7,2.2},
                {7.7,2.6,6.9,2.3},
                {6.0,2.2,5.0,1.5},
                {6.9,3.2,5.7,2.3},
                {5.6,2.8,4.9,2.0},
                {7.7,2.8,6.7,2.0},
                {6.3,2.7,4.9,1.8},
                {6.7,3.3,5.7,2.1},
                {7.2,3.2,6.0,1.8},
                {6.2,2.8,4.8,1.8},
                {6.1,3.0,4.9,1.8},
                {6.4,2.8,5.6,2.1},
                {7.2,3.0,5.8,1.6},
                {7.4,2.8,6.1,1.9},
                {7.9,3.8,6.4,2.0},
                {6.4,2.8,5.6,2.2},
                {6.3,2.8,5.1,1.5},
                {6.1,2.6,5.6,1.4},
                {7.7,3.0,6.1,2.3},
                {6.3,3.4,5.6,2.4},
                {6.4,3.1,5.5,1.8},
                {6.0,3.0,4.8,1.8},
                {6.9,3.1,5.4,2.1},
                {6.7,3.1,5.6,2.4},
                {6.9,3.1,5.1,2.3},
                {5.8,2.7,5.1,1.9},
                {6.8,3.2,5.9,2.3},
                {6.7,3.3,5.7,2.5},
                {6.7,3.0,5.2,2.3},
                {6.3,2.5,5.0,1.9},
                {6.5,3.0,5.2,2.0},
                {6.2,3.4,5.4,2.3},
                {5.9,3.0,5.1,1.8}};
        KMeans kms = new KMeans(test_data);
        kms.setM_NumOfClusters(3);
        int[][] results = kms.DoPartition();
        for (int i =0; i< results.length ;i++){        
            for (int j = 0; j < results[i].length ; j++){
               System.out.format("%d, ", results[i][j]);
            }        
            System.out.println();
        }
        
        //System.out.println("Observations, Sum of squares, Avg Distance, Max Distance  ")
        int[] DataInCluster = kms.getNumOfObservations();
        for(int i =0; i< DataInCluster.length; i++)
            System.out.println(DataInCluster[i]);
	}
	public static class KMeans{
		double [][] m_TestData;
		int m_NumOfClusters;
		int m_TestCases;
		int m_TestVariables;
		double [][] m_Centroid;
		int [][] m_aryResultClusters;
		int MAXLOOP = 100;
		
		public int getM_NumOfClusters(){
			return m_NumOfClusters;
		}
		
		public void setM_NumOfClusters(int mNumOfClusters){
			m_NumOfClusters = mNumOfClusters;
			m_ClusterNo = new int [m_NumOfClusters];
		}
		
		public double [][]getM_TestData(){
			return m_TestData;
		}
		
		public int getM_TestCases(){
			return m_TestCases;
		}
		
		public int getM_TestVariables(){
			return m_TestVariables;
		}
		
		public int[] getM_ClusterNo(){
			return m_ClusterNo;
		}
		
		public double[][] getM_Centroid(){
			return m_Centroid;
		}
		
		int[] m_ClusterNo;
		
		public KMeans(double[][] input_data){
			m_TestData = input_data;
			m_TestCases = input_data.length;
			m_TestVariables = input_data[0].length;
			//m_NumOfGroups = (int)Math.Sqrt(m_TestCases)+ 1;
			m_NumOfClusters = 3;
			m_ClusterNo = new int[m_NumOfClusters];
		}
		
		public double[] getGrandCentroid(){
			double[] ret = new double[this.m_TestVariables];
	        int sum;

	        for(int i=0; i < this.m_TestData.length;i++){
	            sum =0;
	            for(int j=0; j < this.m_TestData[i].length;j++){
	                sum += this.m_TestData[i][j];
	            }
	            ret[i] = sum / this.m_TestCases;            
	        }        
	        return ret;
		}
		
		private int quickSortPartitions(double[][] list,int low,int high) {
		        double prvotkey = list[low][1];
		        double t0, t1;
		        int i, j;
		        i = low; j = high+1;
		        while(true) {
		            do ++i; while( list[i][1] <=  prvotkey && i <= high );
		            do --j; while( list[j][1] > prvotkey );
		            if( i >= j ) break;
		            t0 = list[i][0]; list[i][0] = list[j][0]; list[j][0] = t0;
		            t1 = list[i][1]; list[i][1] = list[j][1]; list[j][1] = t1;
		       }
		       t0 = list[low][0]; list[low][0] = list[j][0]; list[j][0] = t0;
		       t1 = list[low][1]; list[low][1] = list[j][1]; list[j][1] = t1;
		       return j;

		 }
		
		private void quicksort(double[][] list,int low,int high){
	        int prvotloc;
	        if(low < high){
	             prvotloc = quickSortPartitions(list, low, high);    //撠洵銝�甈⊥������璅遘
	             quicksort(list, low, prvotloc - 1); //��艘隤輻���� �low � prvotloc - 1
	             quicksort(list, prvotloc + 1, high); //��艘隤輻���� �  prvotloc + 1� high
	        }
	    }
		
		/*    public int[] getStartingPointArrayIndex(){        
        double[][] testDataDistance = new double[m_TestCases][2];        
        double Distance2Zero = 0.0; //暺蝢支葉敹�(蝢支葉敹���雁����)
        
        for (int m = 0; m < this.m_TestCases;m++) {
            Distance2Zero = 0.0;
            for (int n = 0; n < m_TestVariables; n++) {//4��
                Distance2Zero += Math.pow((m_TestData[m][n] - 0), 2);                                        
            }
            testDataDistance[m][0] = m;
            testDataDistance[m][1] = Distance2Zero;
        }
        for(int i= 0; i < testDataDistance.length;i++){
            System.out.format("%d \n",(int) testDataDistance[i]);
        }
        System.out.println("======================================");
        quicksort(testDataDistance, 0, testDataDistance.length-1);
        for(int i= 0; i < testDataDistance.length;i++){
            System.out.format("%d=%f \n",(int)testDataDistance[i][0], testDataDistance[i][1]);
        }
        int x1 = Math.round(((m_TestCases-1-0)/(1-0))/3);
        int x2 = Math.round((((m_TestCases-1-0)/(1-0))*2)/3);
        double[] avgDist = new double[this.m_NumOfClusters];
        int[] retPos = new int[this.m_NumOfClusters];        
        double sum = 0.0;
        double tmpAvg = 0.0;
        for (int i = 0; i < x1+1 ; i++)
            sum += testDataDistance[i][1];
        avgDist[0]= sum/(x2+1);
        double min = Double.MAX_VALUE;
        int pos =0;
        double tmp;
        for (int i = 0; i < x1+1 ; i++){
            tmp = Math.abs( avgDist[0] - testDataDistance[i][1] );
            if (tmp < min) { min = tmp; pos = i;}
            
        }
        retPos[0] =  pos;        
        
        //*************************************
        sum = 0;
        for (int i = x1+1; i < x2+1 ; i++)
            sum += testDataDistance[i][1];
        avgDist[1] = sum/(x2+1);
        
        min = Double.MAX_VALUE;
        pos =0;
        for (int i = 0; i < x1+1 ; i++){
            tmp = Math.abs( avgDist[1] - testDataDistance[i][1] );
            if (tmp < min) { min = tmp; pos = i;}
            
        }
        retPos[1] =  pos;   
        
        //*************************************
        sum = 0;
        for (int i = x2+1; i < testDataDistance.length ; i++)
            sum += testDataDistance[i][1];
        avgDist[2] = sum/(x2+1);
        
        min = Double.MAX_VALUE;
        pos =0;
        for (int i = 0; i < x1+1 ; i++){
            tmp = Math.abs( avgDist[2] - testDataDistance[i][1] );
            if (tmp < min) { min = tmp; pos = i;}
            
        }
        retPos[2] =  pos;
 
        return retPos;

    }*/
		public int[] getStartingPointArrayIndex(){        
	        double[][] testDataDistance = new double[m_TestCases][2];        
	        double SumData = 0.0; //暺蝢支葉敹�(蝢支葉敹���雁����)
	        
	        for (int m = 0; m < this.m_TestCases;m++) {
	            SumData = 0.0;
	            for (int n = 0; n < m_TestVariables; n++) {//4��
	                SumData += Math.pow((m_TestData[m][n] - 0), 2);                                        
	            }
	            testDataDistance[m][0] = m;
	            testDataDistance[m][1] = SumData;
	        }
	        /*for(int i= 0; i < testDataDistance.length;i++){
	            System.out.format("%d \n",(int) testDataDistance[i]);
	        }*/
	        System.out.println("======================================");
	        //quicksort(testDataDistance, 0, testDataDistance.length-1);
	        for(int i= 0; i < testDataDistance.length;i++){
	            System.out.format("%d=%f \n",(int)testDataDistance[i][0], testDataDistance[i][1]);
	        }
	        int x1 = Math.round(((m_TestCases-1-0)/(1-0))/3);
	        int x2 = Math.round((((m_TestCases-1-0)/(1-0))*2)/3);
	        double[] avgDist = new double[this.m_NumOfClusters];
	        int[] retPos = new int[this.m_NumOfClusters];        
	        double sum = 0.0;
	        double tmpAvg = 0.0;
	        for (int i = 0; i < x1+1 ; i++)
	            sum += testDataDistance[i][1];
	        avgDist[0]= sum/(x2+1);
	        double min = Double.MAX_VALUE;
	        int pos =0;
	        double tmp;
	        for (int i = 0; i < x1+1 ; i++){
	            tmp = Math.abs( avgDist[0] - testDataDistance[i][1] );
	            if (tmp < min) { min = tmp; pos = i;}
	            
	        }
	        retPos[0] =  pos;        
	        
	        //*************************************
	        sum = 0;
	        for (int i = x1+1; i < x2+1 ; i++)
	            sum += testDataDistance[i][1];
	        avgDist[1] = sum/(x2+1);
	        
	        min = Double.MAX_VALUE;
	        pos =0;
	        for (int i = 0; i < x1+1 ; i++){
	            tmp = Math.abs( avgDist[1] - testDataDistance[i][1] );
	            if (tmp < min) { min = tmp; pos = i;}
	            
	        }
	        retPos[1] =  pos;   
	        
	        //*************************************
	        sum = 0;
	        for (int i = x2+1; i < testDataDistance.length ; i++)
	            sum += testDataDistance[i][1];
	        avgDist[2] = sum/(x2+1);
	        
	        min = Double.MAX_VALUE;
	        pos =0;
	        for (int i = 0; i < x1+1 ; i++){
	            tmp = Math.abs( avgDist[2] - testDataDistance[i][1] );
	            if (tmp < min) { min = tmp; pos = i;}
	            
	        }
	        retPos[2] =  pos;
	 
	        return retPos;

	    }
		/*    public int[] getStartingPointArrayIndex(){        
        int[] retPos = new int[this.m_NumOfClusters];   
        double[][] testDataDistance = new double[m_TestCases][2];        
        double SumData = 0.0; //暺蝢支葉敹�(蝢支葉敹���雁����)
        double min = Double.MAX_VALUE;
        int minPos = 0;
        double max = Double.MIN_VALUE;
        int maxPos = 0;      
        
        for (int m = 0; m < this.m_TestCases;m++) {
            SumData = 0.0;
            for (int n = 0; n < m_TestVariables; n++) {//4��
                SumData += Math.pow((m_TestData[m][n] - 0), 2);                                        
            }
            testDataDistance[m][0] = m;
            testDataDistance[m][1] = SumData;
            if ( SumData < min) { min = SumData; minPos = m;}
            if ( SumData > max) { max = SumData; maxPos = m;}            
        }
        
        int width = (int)(max - min)/ m_NumOfClusters;
        double[] distributedData = new double[m_TestCases];   
        for (int m = 0; m < this.m_TestCases;m++) {
            
        }
        
 
        return retPos;

    }*/
		private void EuclideanDistance( double[][] centroid){
	        //閮����蝢支葉敹��嚗���銝���葉
	        //瘥�������蝯衣�� (靘��: iris �����)���雁鞈�������
	        //����黎銝剖���
	        for (int i = 0; i < m_TestCases; i++){ //iris 150 case
	            double tmpDis = 0.0;
	            int idxCluster = 0; //���_ClusterNo����蔭
	            for (int j = 0; j < m_NumOfClusters; j++) //3��黎� 
	            {
	                double Distance2Centroid = 0.0; //暺蝢支葉敹�(蝢支葉敹���雁����)
	                for (int m = 0; m < m_TestVariables; m++) //4��
	                    Distance2Centroid += Math.pow((m_TestData[i][m] - centroid[j][m]), 2);
	                
	                //憒����luster蝺刻�0, ��身m_ClusterNo����揣撘��
	                //�������摮����
	                if (j == 0){
	                    tmpDis = Distance2Centroid;
	                    idxCluster = 0;
	                } else { //����luster蝺刻���0, 隞�銵牢luster =1,2...etc(蝡航��黎�), 
	                    if (tmpDis > Distance2Centroid) {//撠�����策頝��餈�黎銝剖���ㄐ閮�黎��揣撘��
	                        tmpDis = Distance2Centroid;
	                        idxCluster = j;
	                    }
	                    //�ㄐ�隞交��� tmpDis < Distance2Centroid
	                }
	            }
	            int ClusterNo = m_ClusterNo[idxCluster];
	            m_aryResultClusters[idxCluster][ClusterNo] = i + 1;
	            m_ClusterNo[idxCluster]++; //蝝�����(3)蝢日�葉�����
	        }
	    }
		private void EuclideanDistanceSquar( double[][] centroid){
	        //閮����蝢支葉敹��嚗���銝���葉
	        //瘥�������蝯衣�� (靘��: iris �����)���雁鞈�������
	        //����黎銝剖���
	        for (int i = 0; i < m_TestCases; i++){ //iris 150 case
	            double tmpDis = 0.0;
	            int idxCluster = 0; //���_ClusterNo����蔭
	            for (int j = 0; j < m_NumOfClusters; j++) //3��黎� 
	            {
	                double Distance2Centroid = 0.0; //暺蝢支葉敹�(蝢支葉敹���雁����)
	                for (int m = 0; m < m_TestVariables; m++) //4��
	                    Distance2Centroid += Math.pow((m_TestData[i][m] - centroid[j][m]), 2);
	                
	                Distance2Centroid =Math.sqrt(Distance2Centroid);
	                //憒����luster蝺刻�0, ��身m_ClusterNo����揣撘��
	                //�������摮����
	                if (j == 0){
	                    tmpDis = Distance2Centroid;
	                    idxCluster = 0;
	                } else { //����luster蝺刻���0, 隞�銵牢luster =1,2...etc(蝡航��黎�), 
	                    if (tmpDis > Distance2Centroid) {//撠�����策頝��餈�黎銝剖���ㄐ閮�黎��揣撘��
	                        tmpDis = Distance2Centroid;
	                        idxCluster = j;
	                    }
	                    //�ㄐ�隞交��� tmpDis < Distance2Centroid
	                }
	            }
	            int ClusterNo = m_ClusterNo[idxCluster];
	            m_aryResultClusters[idxCluster][ClusterNo] = i + 1;
	            m_ClusterNo[idxCluster]++; //蝝�����(3)蝢日�葉�����
	        }
	    }
		private void ManhattanDistance( double[][] centroid){
	        //閮����蝢支葉敹��嚗���銝���葉
	        //瘥�������蝯衣�� (靘��: iris �����)���雁鞈�������
	        //����黎銝剖���
	        for (int i = 0; i < m_TestCases; i++){ //iris 150 case
	            double tmpDis = 0.0;
	            int idxCluster = 0; //���_ClusterNo����蔭
	            for (int j = 0; j < m_NumOfClusters; j++) //3��黎� 
	            {
	                double Distance2Centroid = 0.0; //暺蝢支葉敹�(蝢支葉敹���雁����)
	                for (int m = 0; m < m_TestVariables; m++) //4��
	                    Distance2Centroid += Math.abs((m_TestData[i][m] - centroid[j][m]));
	                
	                //憒����luster蝺刻�0, ��身m_ClusterNo����揣撘��
	                //�������摮����
	                if (j == 0){
	                    tmpDis = Distance2Centroid;
	                    idxCluster = 0;
	                } else { //����luster蝺刻���0, 隞�銵牢luster =1,2...etc(蝡航��黎�), 
	                    if (tmpDis > Distance2Centroid) {//撠�����策頝��餈�黎銝剖���ㄐ閮�黎��揣撘��
	                        tmpDis = Distance2Centroid;
	                        idxCluster = j;
	                    }
	                    //�ㄐ�隞交��� tmpDis < Distance2Centroid
	                }
	            }
	            int ClusterNo = m_ClusterNo[idxCluster];
	            m_aryResultClusters[idxCluster][ClusterNo] = i + 1;
	            m_ClusterNo[idxCluster]++; //蝝�����(3)蝢日�葉�����
	        }
	    }
		public int[][] DoPartition() {
	        double[][] centroid = new double[m_NumOfClusters][m_TestVariables];
	        int[] grandCent = getStartingPointArrayIndex();
	        
	        //蝢日���
	    /*    for (int i = 0; i < m_NumOfClusters; i++)
	            for (int j = 0; j < m_TestVariables; j++)
	                centroid[i][j] = m_TestData[grandCent[i]][j];*/
	        //蝢文��3暺�
	      /*  for (int i = 0; i < m_NumOfClusters; i++)
	            for (int j = 0; j < m_TestVariables; j++)
	                centroid[i][j] = m_TestData[i][j];*/
	        
	        for (int j = 0; j < m_TestVariables; j++)
	            centroid[0][j] = m_TestData[0][j];
	        for (int j = 0; j < m_TestVariables; j++)
	            centroid[1][j] = m_TestData[50][j];
	        for (int j = 0; j < m_TestVariables; j++)
	            centroid[2][j] = m_TestData[148][j];
	        
	        double[][] preCenter = new double[m_NumOfClusters][m_TestVariables];
	        
	        while (true){
	            m_aryResultClusters = new int[m_NumOfClusters][m_TestCases];

	            //皜征蝢斤楊���
	            for (int i = 0; i < m_NumOfClusters; i++)
	                m_ClusterNo[i] = 0;

	            //閮����蝢支葉敹��嚗���銝���葉
	            //瘥�������蝯衣�� (靘��: iris �����)���雁鞈�������
	            //����黎銝剖���
	            /*for (int i = 0; i < m_TestCases; i++){ //iris 150 case
	                double tmpDis = 0.0;
	                int idxCluster = 0; //���_ClusterNo����蔭
	                for (int j = 0; j < m_NumOfClusters; j++) //3��黎� 
	                {
	                    double Distance2Centroid = 0.0; //暺蝢支葉敹�(蝢支葉敹���雁����)
	                    for (int m = 0; m < m_TestVariables; m++) //4��
	                        Distance2Centroid += Math.pow((m_TestData[i][m] - centroid[j][m]), 2);
	                    
	                    //憒����luster蝺刻�0, ��身m_ClusterNo����揣撘��
	                    //�������摮����
	                    if (j == 0){
	                        tmpDis = Distance2Centroid;
	                        idxCluster = 0;
	                    } else { //����luster蝺刻���0, 隞�銵牢luster =1,2...etc(蝡航��黎�), 
	                        if (tmpDis > Distance2Centroid) {//撠�����策頝��餈�黎銝剖���ㄐ閮�黎��揣撘��
	                            tmpDis = Distance2Centroid;
	                            idxCluster = j;
	                        }
	                        //�ㄐ�隞交��� tmpDis < Distance2Centroid
	                    }
	                }
	                int ClusterNo = m_ClusterNo[idxCluster];
	                m_aryResultClusters[idxCluster][ClusterNo] = i + 1;
	                m_ClusterNo[idxCluster]++; //蝝�����(3)蝢日�葉�����
	            }*/
	            EuclideanDistance( centroid);
	            //EuclideanDistanceSquar( centroid);
	            //ManhattanDistance( centroid);

	            //撠��黎銝剖�摮�誑����
	            for (int i = 0; i < m_NumOfClusters; i++)
	                for (int j = 0; j < m_TestVariables; j++)
	                    preCenter[i][j] = centroid[i][j];

	            //���蝢支葉敹�(蝢日���)
	            for (int i = 0; i < m_NumOfClusters; i++)
	            {
	                int kNum = m_ClusterNo[i];
	                if (kNum > 0)
	                {
	                    for (int j = 0; j < m_TestVariables; j++){
	                        double sum = 0.0;
	                        for (int m = 0; m < kNum; m++){
	                            int groupidxCluster = m_aryResultClusters[i][m] - 1;
	                            sum += m_TestData[groupidxCluster][j];
	                        }
	                        centroid[i][j] = sum / kNum;
	                    }
	                }
	            }

	            //瘥���黎銝剖��銝��
	            boolean bFinish = true;
	            for (int i = 0; i < m_NumOfClusters; i++){
	                for (int j = 0; j < m_TestVariables; j++)
	                {
	                    bFinish = bFinish && (preCenter[i][j] == centroid[i][j]);
	                }
	            }
	            if (bFinish)
	                //銴ˊ蝢支葉敹�
	                for (int i =0; i < centroid.length; i++){
	                    for (int j=0; j< centroid[i].length; j++)
	                        m_Centroid[i][j] = centroid[i][j];
	                }
	                break;

	        }
	        return m_aryResultClusters;
	    }
		public double[] getSumOfSqrByClusters() {
	        double[] ret = new double[0];
	        
	        return ret;
	    }
	    
	    public double[] getAvgDistanceFromCentroid(){
	        double[] ret = new double[0];
	        
	        return ret;    
	    }
	    
	    public double[] getMaxDistanceFromCentroid(){
	        double[] ret = new double[0];
	        
	        return ret;
	    }
	    
	    public int[] getNumOfObservations() {
	        int[] ret = new int[this.m_NumOfClusters];        
	        for (int i=0; i< ret.length; i++)
	            ret[i] =0;
	        
	        for (int i=0;i < this.m_aryResultClusters.length; i++ ){           
	            for (int j=0;j < this.m_aryResultClusters[i].length; j++ ){
	                if ((int)this.m_aryResultClusters[i][j] != 0) 
	                    ret[i]++;
	            }
	            
	        
	        }
	        return ret;
	    }
	    public int[][] getM_aryResultClusters() {
	        return m_aryResultClusters;
	    }
	}
}
