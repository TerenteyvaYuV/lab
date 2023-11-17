package labSix;
import java.util.Arrays;
public class JavaLab6 {
		public static final Object lock = new Object();
		public static void main(String[] args) {
			Integer N=2000;
			int[] array1;
			array1 = new int[N];
			for (Integer i=0; i<N; i++) {
				//Random random = new Random();
			    //array[i] = random.nextInt();
				array1[i] = (int) (Math.random()*(2000+1)) - 1000;
			}
			int[] array2;
			array2 = new int[N];
			for (Integer i=0; i<N; i++) {
				array2[i] = (int) (Math.random()*(2000+1)) - 1000;
			}
			int[] array3;
			array3 = new int[N];
			for (Integer i=0; i<N; i++) {
				array3[i] = (int) (Math.random()*(2000+1)) - 1000;
			}
			JThread NewThr=new JThread(array1);
			Thread t = new Thread(NewThr, "1");
			t.setPriority(6);		
			JThread NewThr2=new JThread(array2);
			Thread t2 = new Thread(NewThr2, "2");
			t2.setPriority(4);		
			JThread NewThr3=new JThread(array3);
			Thread t3 = new Thread(NewThr3, "3");
			t3.setPriority(1);			
			t2.start();
			t.start();
			t3.start();
		}
	static final class JThread implements Runnable {
	    private final int[] array;
		   public JThread(int[] array){	       
		        this.array=array;
		    }
		   @Override
		    public void run(){
		    	printSorted(array); 	        
		    }
	}
	public static void printSorted(int[] array) {	//сортировка выбором (вариант 2)
		for (int i = 0; i < array.length; i++) {    // i - номер текущего шага
	        int pos = i;
	        int min = array[i];
	        // цикл выбора наименьшего элемента
	        for (int j = i + 1; j < array.length; j++) {
	            if (array[j] < min) {
	                pos = j;    // pos - индекс наименьшего элемента
	                min = array[j];
	            }
	        }
	        array[pos] = array[i];
	        array[i] = min;    // меняем местами наименьший с array[i]
	    }
		//пункт 2
		System.out.printf("Массив №"+Thread.currentThread().getName()+": "+Arrays.toString(array)+'\n');
	    
		//пункт3 без синхронизации
		System.out.printf("Массив №"+Thread.currentThread().getName()+'\n');
		for (int j=0; j<(array.length/100); j++) {
			System.out.print("*****");
			for (int i=0; i<100; i++) {
				System.out.print(array[i+j*100]+" ");
			}
			System.out.println("*****");
		}
		
		
		//синхронизацией
		synchronized (JavaLab6.lock) {
			System.out.printf("Массив №"+Thread.currentThread().getName()+'\n');
			for (int j=0; j<(array.length/100); j++) {
				System.out.print("*****");
				for (int i=0; i<100; i++) {
					System.out.print(array[i+j*100]+" ");
				}
				System.out.println("*****");
			}
		}

	}

}
