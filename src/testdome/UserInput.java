package testdome;

public class UserInput {

    public static class TextInput {
        private String value = "";

        public void add(char inputChar){
            this.value += String.valueOf(inputChar);
        }

        public String getValue(){
            return value;
        }
    }

    public static class NumericInput extends TextInput{
        private String value = "";

        @Override
        public void add(char inputChar){
            boolean numberCheck = true;

            try{
                Integer.parseInt(String.valueOf(inputChar));
            }catch (NumberFormatException e){
              // not number
                numberCheck = false;
            }

            if(numberCheck){
                this.value += String.valueOf(inputChar);
            }
        }

        @Override
        public String getValue(){
            return value;
        }

    }

    public static void main(String[] args) {
        TextInput input = new TextInput();
//        TextInput input = new NumericInput();
        input.add('1');
        input.add('a');
        input.add('0');
        input.add('b');
        input.add('!');
        input.add('9');
        input.add('-');
        System.out.println(input.getValue());
    }
}