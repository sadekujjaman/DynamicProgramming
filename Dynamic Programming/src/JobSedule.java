import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class JobSedule {

	public static void main(String[] args){
		
		
		Scanner sc = new Scanner(System.in);
		
//		List<Job> jobL = new ArrayList<>();
//		jobL.add(new Job(2, 60));
//		jobL.add(new Job(1, 100));
//		jobL.add(new Job(3, 20));
//		jobL.add(new Job(2, 40));
//		jobL.add(new Job(1, 20));
//		
//		Collections.sort(jobL);
//		
//		for(Job j : jobL){
//			System.out.println(j.deadline + " " + j.profit);
//		}
	
		int jobs = sc.nextInt();
		
		List<Job>jobList = new ArrayList<>();
		
		for(int i = 0; i < jobs; i++){
			int deadline = sc.nextInt();
			int profit = sc.nextInt();
			jobList.add(new Job(i + 1, deadline, profit));
		}
		Collections.sort(jobList);
		
		int timeSlot = jobList.get(jobs - 1).deadline;
//		System.out.println(timeSlot);
		int slotStatus[] = new int[timeSlot + 1];
		
		int maxProfit = 0;
		for(int i = 0; i < jobs; i++){
			int deadline = jobList.get(i).deadline;
			if(slotStatus[deadline] == 0){
				maxProfit += jobList.get(i).profit;
				slotStatus[deadline] = jobList.get(i).index;
			}
			else{
				for(int j = deadline - 1; j >= 0; j--){
					if(slotStatus[deadline] == 0){
						maxProfit += jobList.get(i).profit;
						slotStatus[deadline] = jobList.get(i).index;
					}
				}
			}
		}
		
		System.out.println(maxProfit);
		
		for(int i = 1; i <= timeSlot; i++){
			if(slotStatus[i] != 0){
				System.out.print("Job" + slotStatus[i] + " ");
			}
		}
		System.out.println();
		
		sc.close();
		
	}
	private static class Job implements Comparable<Job>{
		int deadline;
		int profit;
		int index;
		
		Job(int index, int deadline, int profit){
			this.deadline = deadline;
			this.profit = profit;
			this.index = index;
		}

//		@Override
//		public int compare(Job job1, Job job2) {
//			if(job1.profit > job2.profit){
//				return -1;
//			}
//			else if(job1.profit == job2.profit){
//				if(job1.deadline > job2.deadline){
//					return 1;
//				}
//				else{
//					return -1;
//				}
//			}
//			return 1;
//		}

		@Override
		public int compareTo(Job job2) {
			Job job1 = this;
			if(job1.profit > job2.profit){
				return -1;
			}
			else if(job1.profit == job2.profit){
				if(job1.deadline > job2.deadline){
					return 1;
				}
				else{
					return -1;
				}
			}
			return 1;
		}
		
	}
}
