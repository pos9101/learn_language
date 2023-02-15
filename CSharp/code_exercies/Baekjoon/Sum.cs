//8393 합

using System;

namespace TestMain
{
    class TestClass
    {
        static void Main(String[] args)
        {
            int num = Convert.ToInt32(Console.ReadLine());
            Console.Write(AddNTo1(num));
        }
    
        static int AddNTo1(int num)
        {
            if(num == 1)
                return 1;
            return num + AddNTo1(num-1);
        }
    }  
}
