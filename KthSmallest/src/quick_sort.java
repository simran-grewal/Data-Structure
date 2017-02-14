import java.util.Random;
import java.util.Scanner;

/**
 * Created by i_amg on 13-09-2016.
 */
class quick_sort {
    static void swap( int a[] , int i , int j )
    {
        int temp = a[ i ];
        a[ i ] = a[ j ];
        a[ j ] = temp;
    }
    static int get_pindex( int low , int high )
    {


        Random rand = new Random();
        int pindex = rand.nextInt( high - low + 1 ) + low;
        return pindex;
    }
    static void quicksort( int a[] , int low , int high , int k )
    {
        if( high < low ) return;
        int pindex = get_pindex( low , high );
        swap( a , low , pindex );
        int new_index = low;
        for( int i = low + 1 ; i <= high ; i++ )
        {
            if( a[ i ] <= a[ low ] ) swap( a , i , ++new_index );
        }
        swap( a , low , new_index );
        if( new_index == k ) return;
        if( new_index < k ) quicksort( a , new_index , high  , k );
        if( new_index > k ) quicksort( a , low , new_index , k );
    }
    public static void main( String args[] )
    {
        Scanner scn = new Scanner( System.in );
        int n = scn.nextInt();
        int a[];
        a = new int[ n ];
        for( int i = 0  ;  i < n ; i++ ) a[ i ] = scn.nextInt();
        int k = scn.nextInt();
        quicksort( a , 0 , n - 1  , k - 1 );
        System.out.print( a[ k - 1 ] );
    }
}
