/**
*作者: Bo-Wen Duan (Paul)
*聯絡方式: bowenduan618@gmail.com
*修改日期: 2016 / 1 / 12
*/
/*
K-means 演算法的整個流程：
首先從分群對像中隨機選出K個對像作為群集的質心(初始參數的K代表分群結果的群集數)，
對剩餘的每個對象，根據它們分別到這個K個質心的距離，將它們指定到最相似的群集
(因為K-means是利用距離來量化相似度的，所以我們這裡可以理解為是“將它們指定到離最近最近距離的質心所屬的群集”）。
然後重新計算質心位置。以上過程不斷反複，直到準則函數收斂為止。通常採用平方誤差準則，定義如下：

其中，E代表的意思是所有群集中各對像到​​其所屬群集的質心平方誤差和.
K: 分群結果群集個數
Ci: 第i個群集
P ：群集中分群對象
mi: 第i個群集的質心

K-means的優點和不足：能處理大型資料集，結果群集相當緊湊，並且群集和群集之間明顯分離。計算複雜性O(tkn) t:迭代次數、K：分群數n:樣本數
1) 該演算法必須事先給定群集數和質新，群集數和質心的初始值設定往往會對分群的演算法影響較大。
2) 通常會在獲得一個局部最優值時停止。
3) 並且只適合對數值型資料分群。
4) 只適用於分群結果為球狀的資料庫，K-means方法不適合發現非球狀的分群，或者大小差別很大的群集。
5) 對“噪音”和孤立點數據敏感，少量的該類數據對質心的計算會產生極大的影響。
*/
package KmeansClusteringMain;
import java.io.*;
import java.util.*;
public class KmeansClustering {
	private final static String InputFileName = "iris.arff";      //皜祈岫鞈����
	private final static String OutputFileName = "KmeansResult.txt";  //��黎敺��撓�瑼��
	public static void main(String[] args) throws IOException{		//銝餃撘�
		BufferedReader br = new BufferedReader(new FileReader(InputFileName));  //FileReader���ˇ憿�(BufferedReader)
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(OutputFileName), "Big5")); //FileWriter���ˇ憿�(BufferedWriter)
        String Line,TempString;     //摰����葡敶Ｘ��(Line,TempString)
        String[] TempArray = new String[4];  //摰����葡���empArray嚗��之撠鞈���惇�扳
        ArrayList<String> TestDataList = new ArrayList<>();  //摰�����rrayList(TestDataList)瘜�摮葡
        while((Line = br.readLine())!=null){  //撠���銵�銵��脖��Line��瘥�銵����霈����null��歲�餈游��
        	TempString = Line; //�TempString��Line����銵摰�
        	TempArray = TempString.split(","); //撠empString(瘥�銵���)隞�","雿��暺�脰��嚗�TempArray���葉
             for(int i=0 ; i<TempArray.length ; i++){  //撠empArray�������TestDataList銝�
            	 TestDataList.add(TempArray[i]);
             }
        }
        int TestDataCount = TestDataList.size()/4; //摰��������TestDataCount嚗TestDataList�隞亥���惇�批�(鞈���)
        int count = 0; //摰��������count�0
        double[][] TestData = new double[TestDataCount][4];  //摰���ouble����雁����(TestData)嚗��之撠鞈���嚗摨衣瘥�����惇�批�
        for(int x=0 ; x < TestDataCount ; x++){  //�����(撌Ｙ�)for餈游���count雿index��TestDataList���葡嚗���葡頧��ouble靘��鈭雁���葉
            for(int y = 0 ; y < 4 ; y++){
            	TestData[x][y] = Double.parseDouble(TestDataList.get(count));
                count++; 
            }
        }
        KMeans km = new KMeans(TestData);  //摰�����Means憿霈km嚗�estData雿撘��
        km.SetNumOfClusters(3);   //閮剖���黎�
        int[][] Results = km.DoPartition();  //摰��������雁����(Results)嚗�km��oPartition()�����������雁����
        double[][] TestDataDistance = km.GetDisTestData();
        double[][] CentroidPoint = km.GetCentroid();
        int[] DataInCluster = km.GetNumOfObservations(); //摰����������(DataInCluster)嚗�km��etNumOfObservations()�������������
        bw.write("頛詨��������: " + InputFileName); bw.newLine();
        bw.write("����������������憒��:"); bw.newLine();
        for(int i= 0; i < TestDataDistance.length;i++){
            bw.write("蝚�"+((int)TestDataDistance[i][0]+1)+"蝑���"+" "+"頝撟單�"+(float)TestDataDistance[i][1]);
            bw.newLine();
        }
        bw.newLine(); bw.write("��黎�: " + km.GetNumOfClusters()); bw.newLine();
        bw.write("*****��黎蝯����*****"); bw.newLine();
        for (int i = 0 ; i < Results.length ; i++){  //�����(撌Ｙ�)for餈游���雁����(Results)靘���靘�
        	sop(DataInCluster[i]);
        	bw.write("蝚�" + (i+1) + "�luster 蝮賢���" + DataInCluster[i] + "蝑���"); bw.newLine();
        	bw.write("�澆�: (" + (float)CentroidPoint[i][0] + "," + (float)CentroidPoint[i][1] 
        			+ "," + (float)CentroidPoint[i][2] + "," + (float)CentroidPoint[i][3] + ")"); bw.newLine();
            for (int j = 0; j < Results[i].length ; j++){
            	if(Results[i][j] != 0) {
            	 bw.write("蝚�" + Results[i][j] + "蝑���");
            	 bw.write("(" + TestDataList.get(Results[i][j]*4-4) + "," + TestDataList.get(Results[i][j]*4-3)+ "," 
            			 	  + TestDataList.get(Results[i][j]*4-2) + "," + TestDataList.get(Results[i][j]*4-1) + ")");
            	 bw.newLine();
            	}
            }        
            bw.write("<==========================>"); bw.newLine();//鋆⊿for餈游����頛芷�脰����   
        }  
        br.close();   //頛詨瑼���
        bw.close();  //��黎蝯�撓�瑼���
        sop("Mining蝯������" + OutputFileName + "���ining蝯��");
	}
	public static void sop(Object obj){  //����unction
    	System.out.println(obj);
    }
	public static class KMeans {      //�����(KMeans)
	    double[][] TestData;  //摰���ouble鈭雁����(TestData)
	    double[][] DisTestData; //摰���ouble鈭雁����(DisTestData)
	    int NumOfClusters;	//摰��������(NumOfClusters)
	    int TestCases;		//摰��������(TestCases)
	    int TestAttributes;	//摰��������(TestAttributes)
	    double[][] Centroid;  //摰���ouble鈭雁����(Centroid)
	    int[][] AryResultClusters;  //摰����鈭雁����(AryResultClusters)
	    int[] ClusterNo;	   //摰��������(ClusterNo)
	    public int GetNumOfClusters() {  //�撘etNumOfClusters嚗���NumOfClusters
	        return NumOfClusters;
	    }
	    public void SetNumOfClusters(int mNumOfClusters) {//�撘etNumOfClusters嚗��銝���
	        NumOfClusters = mNumOfClusters;	//NumOfClusters����脖����
	        ClusterNo = new int[NumOfClusters];	 //�����lusterNo憭批�恐��NumOfClusters
	    }
	    public double[][] GetTestData() { //�撘etTestData嚗�double鈭雁���estData
	        return TestData;
	    }
	    public int GetTestCases() { //�撘etTestCases嚗���TestCases
	        return TestCases;
	    }
	    public int GetTestAttributes() { //�撘etTestAttributes()嚗���TestAttributes
	        return TestAttributes;
	    }
	    public int[] GetClusterNo() { //�撘etClusterNo()嚗������lusterNo
	        return ClusterNo;
	    }
	    public double[][] GetCentroid() { //�撘etCentroid()嚗�double鈭雁���entroid
	        return Centroid;
	    }
	    public double[][] GetDisTestData() { //�撘etDisTestData()嚗�double鈭雁���isTestData
	        return DisTestData;
	    }
	    public KMeans(double[][] input_data){ //撱箸��Means嚗��double鈭雁����(input_data)
	        TestData = input_data;	//TestData��double鈭雁����(input_data)
	        TestCases = TestData.length;	//TestCases�TestData�摨�(鞈���)
	        TestAttributes = TestData[0].length; //TestAttributes�TestData[0]�摨�(撅祆�批�)
	        ClusterNo = new int[NumOfClusters];	 //�����lusterNo憭批�恐��NumOfClusters
	    }
		public int[] GetStartingPointArrayIndex(){        
	        double[][] testDataDistance = new double[TestCases][2];        
	        double SumData = 0.0; //暺蝢支葉敹�(蝢支葉敹���雁����)
	        for (int m = 0; m < this.TestCases;m++) {
	            SumData = 0.0;
	            for (int n = 0; n < TestAttributes; n++) {//4��
	                SumData += Math.pow((TestData[m][n] - 0), 2);                                        
	            }
	            testDataDistance[m][0] = m;
	            testDataDistance[m][1] = SumData;
	        }
	        this.DisTestData = testDataDistance;
	        int[] retPos = new int[this.NumOfClusters];
	        int p1 = (int)((Math.random())*(this.TestCases));  
	        int tempp = 0; int tempp1 = 0; 
	        double tempd = 0.0; double tempd1 = Double.MAX_VALUE;
	        retPos[0] =  p1;
	        for(int i = 0 ; i < TestCases ; i++){
	        	double tempDis = 0.0;
	        	for(int j = 0 ; j < TestData[i].length ; j++){
	        		tempDis += Math.pow((TestData[retPos[0]][j] - TestData[i][j]), 2);
	        	}
	        	if(tempDis  > tempd)
	        		tempp = i;
	        		tempd = tempDis;
	        		tempDis = 0.0;
	        }
	        retPos[1] =  tempp; 
	        for(int i = 0 ; i < TestCases ; i++){
	        	double tempDis1 = 0.0;
	        	for(int j = 0 ; j < TestData[i].length ; j++){
	        		tempDis1 += Math.pow((TestData[retPos[0]][j] - TestData[i][j]), 2)
	        				+ Math.pow((TestData[retPos[1]][j] - TestData[i][j]), 2);
	        	}
	        	if(tempDis1 < tempd1)
	        		tempp1 = i;
	        		tempd1 = tempDis1;
	        		tempDis1 = 0.0;
	        }
	        retPos[2] =  tempp1;
	        return retPos;
	    }
		private void EuclideanDistance(double[][] centroid){ //閮��嗾����(頝撟單)嚗�����蝢支葉敹��嚗���銝���葉
	        for (int i = 0; i < TestCases; i++){  
	            double tmpDis = 0.0;
	            int idxCluster = 0; //���lusterNo����蔭(index)
	            for (int j = 0; j < NumOfClusters; j++) { 	//��黎� 
	                double Distance2Centroid = 0.0; 		//暺蝢支葉敹�
	                for (int m = 0; m < TestAttributes; m++) {		//撅祆�扳
	                    Distance2Centroid += Math.pow((TestData[i][m] - centroid[j][m]), 2);  //頝撟單
	                }
	                //�������摮����
	                if (j == 0){   //憒����luster蝺刻�0, ��身ClusterNo����揣撘��
	                    tmpDis = Distance2Centroid;
	                    idxCluster = 0;
	                } else { 	  //����luster蝺刻��0, 隞�銵牢luster =1,2...etc 
	                    if (tmpDis > Distance2Centroid) {   //撠�����策頝��餈�黎銝剖��
	                        tmpDis = Distance2Centroid;
	                        idxCluster = j;   //�ㄐ閮��撅祉黎���揣撘��
	                    }
	                }
	            }
	            int ClusterNumber = ClusterNo[idxCluster];
	            AryResultClusters[idxCluster][ClusterNumber] = i + 1;  //閮���蝢日�����楊���(index+1)
	            ClusterNo[idxCluster]++; //蝝����黎��葉�����
	        }
	    }
		public int[][] DoPartition() {
	        double[][] centroid = new double[NumOfClusters][TestAttributes];  //���釭敹�
	        Centroid = new double[NumOfClusters][TestAttributes];  //���釭敹�
	        int[] grandCent = GetStartingPointArrayIndex();
	        for (int j = 0; j < TestAttributes; j++){    //閮剖���釭敹�
	            centroid[0][j] = TestData[grandCent[0]][j];
	        }
	        for (int j = 0; j < TestAttributes; j++){
	            centroid[1][j] = TestData[grandCent[1]][j];
	        }
	        for (int j = 0; j < TestAttributes; j++){
	            centroid[2][j] = TestData[grandCent[2]][j];
	        }
	        double[][] preCenter = new double[NumOfClusters][TestAttributes];
	        while (true){
	        	AryResultClusters = new int[NumOfClusters][TestCases];
	            for (int i = 0; i < NumOfClusters; i++)  //皜征蝢斤楊���
	                ClusterNo[i] = 0;
	            EuclideanDistance(centroid);
	            for (int i = 0; i < NumOfClusters; i++)  //撠��黎銝剖�摮preCenter嚗誑����
	                for (int j = 0; j < TestAttributes; j++)
	                    preCenter[i][j] = centroid[i][j];
	            for (int i = 0; i < NumOfClusters; i++){  //���蝢支葉敹�(蝢日���)
	                int kNum = ClusterNo[i];  //瘥�蝢日���
	                if (kNum > 0){
	                    for (int j = 0; j < TestAttributes; j++){
	                        double sum = 0.0;
	                        for (int m = 0; m < kNum; m++){    //瘥�蝢日�ㄐ����������惇�抒���隞亦黎������
	                            int groupidxCluster = AryResultClusters[i][m] - 1;
	                            sum += TestData[groupidxCluster][j];
	                        }
	                        centroid[i][j] = sum / kNum;
	                    }
	                }
	            }
	            //瘥���黎銝剖��銝��
	            boolean bFinish = true;
	            for (int i = 0 ; i < NumOfClusters ; i++){
	                for (int j = 0 ; j < TestAttributes ; j++){
	                	bFinish = bFinish && ( preCenter[i][j] == centroid[i][j] );
	                }
	            }
	            if (bFinish){ //銴ˊ蝢支葉敹�
	                for (int i =0 ; i < centroid.length ; i++){
	                    for (int j=0 ; j< centroid[i].length ; j++){
	                    	Centroid[i][j] = centroid[i][j];
	                    }
	                }
	                break;
	            }
	        }
	        return AryResultClusters;
	    }
	    public int[] GetNumOfObservations() {
	        int[] ret = new int[this.NumOfClusters];        
	        for (int i=0; i< ret.length; i++)
	            ret[i] =0;
	        for (int i=0;i < this.AryResultClusters.length; i++ ){           
	            for (int j=0;j < this.AryResultClusters[i].length; j++ ){
	                if ((int)this.AryResultClusters[i][j] != 0) 
	                    ret[i]++;
	            }
	        }
	        return ret;
	    }
	    public int[][] GetAryResultClusters() {
	        return AryResultClusters;
	    }
	}
}