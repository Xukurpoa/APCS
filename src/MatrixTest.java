public class MatrixTest {
    public static void main(String[] args){
        try {
        Matrix m = new Matrix(2,1);
        Matrix matrix = new Matrix(1,2);
        Matrix a = new Matrix(10,10);

            m.set(0,0, 5.0);
            m.set(1,0, 6);
            matrix.set(0,0,2);
            matrix.set(0,1,4);

            print(Matrix.add(m,matrix));
            print(Matrix.sub(m,matrix));
            print(Matrix.mult(m, 10));
            print(Matrix.mult(m,matrix));
            print(Matrix.transpose(m));
            int counter = 0;
            /*for(int x = 0; x < a.getRow(); x++){
                for(int y = 0; y < a.getColumn(); y++){
                    a.set(x,y,counter);
                    counter++;
                }
            }*/
            print(a);
            print(Matrix.transpose(a));
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    private static void print(Matrix m)throws Matrix.MatrixException{
        /*for(int x = 0; x < m.getRow(); x++){
            for (int y = 0; y < m.getColumn(); y++){
                System.out.print(m.get(x,y)+" ");
            }
            System.out.println("");
        }
        System.out.println("");*/
    }
}
