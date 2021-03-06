import java.util.Stack;

class SumofBigValue {

    static class Node
    {
        int data;
        Node next;

        public Node(int data)
        {
            this.data = data;
        }
    }

    static Node l1, l2, result;

    // To push a new node to linked list
    public static void push(int new_data)
    {

        // Allocate node
        Node new_node = new Node(0);

        // Put in the data
        new_node.data = new_data;

        // Link the old list off the new node
        new_node.next = l1;

        // Move the head to point to the new node
        l1 = new_node;
    }

    public static void push1(int new_data)
    {

        // Allocate node
        Node new_node = new Node(0);

        // Put in the data
        new_node.data = new_data;

        // Link the old list off the new node
        new_node.next = l2;

        // Move the head to point to
        // the new node
        l2 = new_node;
    }

    // To add two new numbers
    public static Node addTwoNumbers()
    {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        while (l1 != null)
        {
            stack1.add(l1.data);
            l1 = l1.next;
        }

        while (l2 != null)
        {
            stack2.add(l2.data);
            l2 = l2.next;
        }

        int carry = 0;
        Node result = null;

        while (!stack1.isEmpty() ||
                !stack2.isEmpty())
        {
            int a = 0, b = 0;

            if (!stack1.isEmpty())
            {
                a = stack1.pop();
            }

            if (!stack2.isEmpty())
            {
                b = stack2.pop();
            }

            int total = a + b + carry;

            Node temp = new Node(total % 10);
            carry = total / 10;

            if (result == null)
            {
                result = temp;
            }
            else
            {
                temp.next = result;
                result = temp;
            }
        }

        if (carry != 0)
        {
            Node temp = new Node(carry);
            temp.next = result;
            result = temp;
        }
        return result;
    }

    // To print a linked list
    public static StringBuilder printList()
    {
        StringBuilder resultInString = new StringBuilder("");
        while (result != null)
        {
            resultInString.append(result.data);
            result = result.next;
        }
       return resultInString;
    }


    public static void main(String[] args)
    {
        String a= "123456789012345678901";
        String b ="12345678";
       // String a= "123";
       // String b ="11";
        System.out.println(" first Value: "+a);
        System.out.println(" second value: "+b);
        System.out.println(" result :"+addTwoLargeNumber(a,b));

    }

    private static StringBuilder addTwoLargeNumber(String a, String b){
    if(a.isEmpty()&&b.isEmpty()){
        return new StringBuilder(" input values are empty");
    }
        int[] arr1 = convertIntArrayFromString(a);
        int[] arr2 = convertIntArrayFromString(b);

        int i;
        for(i = arr1.length - 1; i >= 0; --i)
            push(arr1[i]);
        for(i = arr2.length - 1; i >= 0; --i)
            push1(arr2[i]);

        result = addTwoNumbers();

        return printList();
    }

    private static int[] convertIntArrayFromString(String a){
        String[] arrString1 = a.split("");
        // Initializing int array with size equal to string array
        int[] intArray = new int[a.length()];
        //Converting string array to int array
        for (int j = 0; j < intArray.length; j++) {
            intArray[j] = Integer.parseInt(arrString1[j]);
        }
        return intArray;
    }


}
