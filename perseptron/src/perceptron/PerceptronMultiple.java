package perceptron;

import java.util.Random;

public class PerceptronMultiple {
	public static final double UMBRAL=0.00000001f;
	public static final double ALFA=0.5f;
	
	public int N=2;
	public int M=2;
	public int Q=4;
	public int L=4;

	
	public double[][] x;
	public double[][] d;
	
	public double[] y;
	public double[] yh;
	public double[] neth;
	public double[] neto;
	public double[] deltao;
	public double[] deltah;
	public double[][] wh;
	public double[][] wo;
	
	public PerceptronMultiple(int N,int M,int Q,int L,double[][] x,double[][] d){
		this.N=N;
		this.M=M;
		this.Q=Q;
		this.L=L;
		this.x=x;
		this.d=d;
		iniciar();
		aprender();
	}
	
	private void iniciar(){
		y=new double[M];
		yh=new double[L];
		neth=new double[L];
		neto=new double[M];
		deltao=new double[M];
		deltah=new double[L];
		wh=new double[L][N];
		wo=new double[M][L];
		Random r=new Random();
		for(int i=0;i<L;i++){
			for(int j=0;j<N;j++){
				wh[i][j]=r.nextDouble();
			}
			for(int j=0;j<M;j++){
				wo[j][i]=r.nextDouble();
			}
		}
	}
	
	public void aprender(){
		double error=0;
		do{
			for(int p=0;p<Q;p++){
				for(int j=0;j<L;j++){
					double sumaNetH=0;
					for(int i=0;i<N;i++){
						sumaNetH+=x[i][p]*wh[j][i];
					}
					neth[j]=sumaNetH;
					yh[j]=(double)(1.0/(1.0+Math.exp(-neth[j])));
				}
				
				for(int k=0;k<M;k++){
					double sumatoriaDeltaPesoO=0;
					for(int j=0;j<L;j++){
						sumatoriaDeltaPesoO+=yh[j]*wo[k][j];
					}
					neto[k]=sumatoriaDeltaPesoO;
					y[k]=(1.0/(1.0+Math.exp(-neto[k])));
					deltao[k]=(d[k][p]-y[k])*y[k]*(1-y[k]);
				}
				for(int j=0;j<L;j++){
					double sumatoriaDeltaPesoO=0;
					for(int k=0;k<M;k++){
						sumatoriaDeltaPesoO+=deltao[k]*wo[k][j];
					}
					deltah[j]=yh[j]*(1-yh[j])*sumatoriaDeltaPesoO;
				}
				for(int j=0;j<L;j++){
					for(int k=0;k<M;k++){
						wo[k][j]+=ALFA*deltao[k]*yh[j];
					}
				}
				for(int j=0;j<L;j++){
					for(int i=0;i<N;i++){
						wh[j][i]+=ALFA*deltah[j]*x[i][p];
					}
				}
			}
			double sumatoria=0;
			for(int k=0;k<M;k++){
				sumatoria+=deltao[k]*deltao[k];
			}
			error=sumatoria/2;
		}while(error>UMBRAL);
	}
	public double[][] ejecutar(double[][] x,int R){
		if(x==null||x.length!=N){
			throw new IllegalArgumentException();
		}
		double[][] Y=new double[M][R];
		for(int p=0;p<R;p++){
			for(int j=0;j<L;j++){
				double sumaNetH=0;
				for(int i=0;i<N;i++){
					sumaNetH+=x[i][p]*wh[j][i];
				}
				neth[j]=sumaNetH;
				yh[j]=(1.0/(1.0+Math.exp(-neth[j])));
			}
			for(int k=0;k<M;k++){
				double sumatoriaDeltaPesoO=0;
				for(int j=0;j<L;j++){
					sumatoriaDeltaPesoO+=yh[j]*wo[k][j];
				}
				neto[k]=sumatoriaDeltaPesoO;
				Y[k][p]=(1.0/(1.0+Math.exp(-neto[k])));
			}
		}
		return Y;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[][] x=new double[2][4];
		double[][] d=new double[2][4];
		x[0][0]=0;
		x[0][1]=0;
		x[0][2]=1;
		x[0][3]=1;
		
		x[1][0]=0;
		x[1][1]=1;
		x[1][2]=0;
		x[1][3]=1;
		
		d[0][0]=1;
		d[0][1]=1;
		d[0][2]=1;
		d[0][3]=0;
		
		d[1][0]=0;
		d[1][1]=0;
		d[1][2]=0;
		d[1][3]=1;
		
		PerceptronMultiple p=new PerceptronMultiple(2,2,4,4,x,d);
		
		for(double[] x1:p.ejecutar(x,4)){
			for(double y:x1){
				System.out.println(y+"---");
			}
			System.out.println();
		}
	}

}
