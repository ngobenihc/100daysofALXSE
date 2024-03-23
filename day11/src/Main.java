public class Main {
    public static void main(String[] args) {
        decimal_Hexadecimal obj = new decimal_Hexadecimal();
        int num_btw_2_N_10 = obj.Decimal_Num();
        obj.convert_Decimal_To_Haxedecimal();

        //checking if the number is between 2 and 10 to convert to binaries and decimal
        if (num_btw_2_N_10 > 1 && num_btw_2_N_10 <= 10) {
            int binary_decimal = obj.convert_Decimal_To_Binary();
            obj.convert_Binary_To_Decimal(binary_decimal);
        }
    }
}