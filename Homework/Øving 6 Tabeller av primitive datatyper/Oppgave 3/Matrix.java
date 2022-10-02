import java.util.Scanner;

public class Matrix {
 
    int numColumns;
    int numRows;
    int[][] matrixArray;
    static Matrix mainMatrix = new Matrix();
    static int multRow;
    static int multColumn;

    public Matrix(){
        numColumns = 10000;
        numRows = 10000;
        this.matrixArray = new int[numColumns][numRows];
    }
    public static void main(String[] args){
        mainMatrix.setMatrix();
        uInterface();
    }

    public static void uInterface(){

        Scanner option = new Scanner(System.in);
        System.out.println("If you want to create your matrix again, press 1.\nIf you want to check your matrix, press 2.\nIf you want to add another matrix to your matrix, press 3.\nIf you want to multiply your matrix by another matrix, press 4. \nIf you want to transpose your matrix, press 5.\n");
        int opt = option.nextInt();

        if(opt == 1){
            mainMatrix.setMatrix();
        }
        else if(opt == 2){
            mainMatrix.getMatrix();
        }
        else if(opt == 3){
            addMatrix();
        }
        else if(opt == 4){
            mainMatrix.multiplyMatrix();
        }
        else if(opt == 5){
            mainMatrix.transposeMatrix();
        }
        else{
            uInterface();
        }
        uInterface();

    }

    public void setMatrix(){

        Scanner matrixQuestion1 = new Scanner(System.in);
        System.out.println("What do you want the dimensions of your matrix to be? \nHow many rows do you want?");
        mainMatrix.numRows = matrixQuestion1.nextInt();

        Scanner matrixQuestion2 = new Scanner(System.in);
        System.out.println("How many columns do you want?");
        mainMatrix.numColumns = matrixQuestion2.nextInt();

        for(int i = 0; i < mainMatrix.numRows; i++){
            for(int j = 0; j < mainMatrix.numColumns; j++){
                Scanner matrixIndex = new Scanner(System.in);
                System.out.println("What number do you want for the [" + i + "]["  + j + "] index of the matrix?");
                int matrixInput = matrixIndex.nextInt();
                mainMatrix.matrixArray [i][j] = matrixInput;
            }
        }
        mainMatrix.getMatrix();
    }

    public void getMatrix(){
        System.out.println("\nYour matrix: \n");
        for(int i = 0; i < numRows; i++){
            for(int j = 0; j < numColumns; j++){
                System.out.print(" " + matrixArray[i][j] + " ");
            }
            System.out.println("\n");
        }
    }

    public static void addMatrix(){

        System.out.println("First, you have to create the matrix you want to add to your matrix.");
        Matrix addMatrix = new Matrix();
        for(int i = 0; i < mainMatrix.numRows; i++){
            for(int j = 0; j < mainMatrix.numColumns; j++){
                Scanner addMatrixIndex = new Scanner(System.in);
                System.out.println("What number do you want for the [" + i + "]["  + j + "] index of the matrix?");
                int matrixInput2 = addMatrixIndex.nextInt();
                addMatrix.matrixArray [i][j] = matrixInput2;
            }
        }

        System.out.println("Just to double check. You want the following two matrices added: ");
        System.out.println("Your matrix: ");
        mainMatrix.getMatrix();

        System.out.println("The matrix to be added: \n");
        for(int i = 0; i < mainMatrix.numRows; i++){
            for(int j = 0; j < mainMatrix.numColumns; j++){
                System.out.print(" " + addMatrix.matrixArray[i][j] + " ");
            }
            System.out.println("\n");
        }
        
        System.out.println("If you want to go back, press 1.\nIf you want to add the two, press 2.");
        Scanner addOpt = new Scanner(System.in);
        int addOption = addOpt.nextInt();

        if(addOption == 1){
            uInterface();
        }
        else if(addOption == 2){
            for(int i = 0; i < mainMatrix.numRows; i++){
                for(int j = 0; j < mainMatrix.numColumns; j++){
                    mainMatrix.matrixArray[i][j] = mainMatrix.matrixArray[i][j] + addMatrix.matrixArray [i][j];
                }
            }
        }
        mainMatrix.getMatrix();
        uInterface();
    }

    public void multiplyMatrix(){

        System.out.println("First, you have to create the matrix you want to multiply your matrix by. \nIn order for your multiplying matrix to be valid, the number of rows it contains has to be equal to the number of columns in the main matrix.");

        Scanner matrixQuestion3 = new Scanner(System.in);
        System.out.println("What do you want the dimensions of your matrix to be? \n \nHow many rows do you want?");
        multRow = matrixQuestion3.nextInt();

        Scanner matrixQuestion4 = new Scanner(System.in);
        System.out.println("How many columns do you want?");
        multColumn = matrixQuestion4.nextInt();

        if(multRow != mainMatrix.numColumns){
            System.out.println("\nThis multiplying matrix is invalid. Try another one with the same number of rows and columns in the main matrix: " + mainMatrix.numColumns +"\n");
            multiplyMatrix();

        }

        else{

            System.out.println("This is a valid matrix!");

            int[][] multiplyingMatrix = new int[multRow][multColumn];

            for(int i = 0; i < multRow; i++){
                for(int j = 0; j < multColumn; j++){
                    Scanner matrixIndex = new Scanner(System.in);
                    System.out.println("What number do you want for the [" + i + "]["  + j + "] index of the matrix?");
                    int matrixInput = matrixIndex.nextInt();
                    multiplyingMatrix[i][j] = matrixInput;
                }
            }


            System.out.println("Just to double check. You want the following two matrices multiplied: ");
            System.out.println("Your matrix: ");
            mainMatrix.getMatrix();

            System.out.println("The multiplying matrix: \n");
            for(int i = 0; i < multRow; i++){
                for(int j = 0; j < multColumn; j++){
                    System.out.print(" " + multiplyingMatrix[i][j] + " ");
                }
                System.out.println("\n");
            }

            System.out.println("If you want to go back, press 1.\nIf you want to multiply the two, press 2.");
            Scanner multOpt = new Scanner(System.in);
            int multOption = multOpt.nextInt();

            if(multOption == 1){
                uInterface();
            }

            else if(multOption == 2){

                int[][] storageMatrix = new int[mainMatrix.numRows][mainMatrix.numColumns];
        
                for(int i = 0; i < mainMatrix.numRows; i++){
                    for(int j = 0; j < mainMatrix.numColumns; j++){
                        storageMatrix[i][j] = this.matrixArray[i][j];
                    }
                }

                int storageVal = mainMatrix.numColumns;

                mainMatrix.numColumns = multColumn;

                for(int i = 0; i < mainMatrix.numRows; i++){
                        for(int k = 0; k < multColumn; k++){   
                            mainMatrix.matrixArray[i][k] = 0; 
                            for(int j = 0; j < storageVal; j++){
                                mainMatrix.matrixArray[i][k] += (storageMatrix[i][j] * multiplyingMatrix [j][k]);
                            }
                        }    
                }
            }
            mainMatrix.getMatrix();
            uInterface();
            
        }

    }

    public void transposeMatrix(){
        int[][] storageMatrix = new int[mainMatrix.numRows][mainMatrix.numColumns];
        
        for(int i = 0; i < mainMatrix.numRows; i++){
            for(int j = 0; j < mainMatrix.numColumns; j++){
                storageMatrix[i][j] = this.matrixArray[i][j];
            }
        }

        int storageVal = mainMatrix.numRows;
        mainMatrix.numRows = mainMatrix.numColumns;
        mainMatrix.numColumns = storageVal;

        for(int i = 0; i < mainMatrix.numRows; i++){
            for(int j = 0; j < mainMatrix.numColumns; j++){
                mainMatrix.matrixArray [i][j] = storageMatrix[j][i]; 
            }
        }
        mainMatrix.getMatrix();
    }
}