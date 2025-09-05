/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuongqui.mathutil.core;

import static com.tuongqui.mathutil.core.MathUtil.*;
// import static là kỹ thuật dành riêng cho static, gọi làm mà bỏ qua tên class
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 *
 * @author ADMIN
 */
public class MathUtilTest {
    
    // chơi DDT. tách data ra khỏi câu lệnh kiểm thử, tham số hóa data này vào trong câu lệnh kiểm thử
    
    // chuẩn bị data
    public static Object [][]initData(){
        return new Integer [][]{
                                    {1,1},
                                    {2,2},
                                    {5,120},
                                    {6,720},
                                };
    }
    
    @ParameterizedTest
    @MethodSource(value = "initData") // tên hàm cung cấp data, ngầm định thứ tự củacác phần tử mảng, map vào tham số hàm
   public void testGetFactotialGivenRightArgReturnWell(int input, long expected){
       assertEquals(expected, getFactorial(input));
   }
    
//   @Test
//   public void testGetFactotialGivenRightArgReturnWell(){
//       assertEquals(24, getFactorial(4));
//   }
   
   // Bắt ngoại lệ khi đưa data sai
   // @Test ( expected = tên ngoại lệ) chỉ dùng cho Junit 4
   @Test
   public void testGetFactorialGivenWrongArgThrowException(){
       // dùng biểu thức Lambda
       
       // Excutable là một function interface của JUnit5 và interface này chỉ có 1 hàm duy nhất là execute là không có code. Nhét đoạn code muốn chạy vào interface này rồi lấy kết quả nhét vào assert để test
       
       // Cách 1: chơi chậm
       Executable exObject = new Executable() {
           @Override
           public void execute() throws Throwable {
               getFactorial(-5);
           }
       };
       
       // Cách 2: Không cần new
//       Executable exObject = () -> getFactorial(-5);
       
       
       // hàm nhận tham số thứ 2 là 1 cái object/ có code implement cái function interface  tên là Excutable - có 1 làm duy nhất ko có code 
       // tên là execute() 
//       
//       assertThrows(IllegalArgumentException.class, exObject);
       
       // Cách 3: Viết trực tiếp trong assert luôn
       assertThrows(IllegalArgumentException.class, () -> getFactorial(-5));
   }
    
}
