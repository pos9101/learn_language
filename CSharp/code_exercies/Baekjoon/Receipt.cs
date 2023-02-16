// Receipt.cs

using System;

namespace Test
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int price = Convert.ToInt32(Console.ReadLine());
            int kindNum = Convert.ToInt32(Console.ReadLine());
            int tempPrice = 0;
            for(int i = 0; i < kindNum; i++) {
                try {
                    var line = Console.ReadLine();
                    if(line != null) {
                        string[] data = line.Split(' ');
                        tempPrice += Convert.ToInt32(data[0]) * Convert.ToInt32(data[1]);  
                    }
                } catch(FormatException e) {
                    Console.WriteLine(e);
                }
            }
            if(price == tempPrice)
                Console.Write("Yes");
            else    
                Console.Write("No");
        }
    }
    
}