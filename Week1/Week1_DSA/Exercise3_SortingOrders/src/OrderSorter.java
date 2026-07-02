public class OrderSorter {
    public static Order[] bubbleSort(Order[] orders) {
        Order[] arr = copyArray(orders);
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n-i-1; j++) {
                if (arr[j].getTotalPrice() > arr[j+1].getTotalPrice()) {
                    Order t = arr[j]; arr[j] = arr[j+1]; arr[j+1] = t;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
        return arr;
    }
    public static Order[] quickSort(Order[] orders) {
        Order[] arr = copyArray(orders);
        quickSortHelper(arr, 0, arr.length-1);
        return arr;
    }
    private static void quickSortHelper(Order[] arr, int low, int high) {
        if (low < high) { int pi = partition(arr, low, high); quickSortHelper(arr, low, pi-1); quickSortHelper(arr, pi+1, high); }
    }
    private static int partition(Order[] arr, int low, int high) {
        double pivot = arr[high].getTotalPrice(); int i = low-1;
        for (int j = low; j < high; j++) { if (arr[j].getTotalPrice() <= pivot) { i++; Order t=arr[i]; arr[i]=arr[j]; arr[j]=t; } }
        Order t=arr[i+1]; arr[i+1]=arr[high]; arr[high]=t;
        return i+1;
    }
    private static Order[] copyArray(Order[] orders) { Order[] c = new Order[orders.length]; System.arraycopy(orders, 0, c, 0, orders.length); return c; }
    public static void printOrders(Order[] orders) { for (Order o : orders) System.out.println("  " + o); }
}