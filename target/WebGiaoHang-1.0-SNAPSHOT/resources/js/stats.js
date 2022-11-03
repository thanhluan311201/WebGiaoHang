/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


function donhangChart(id, userLabels=[], userInfo=[]){
    const data = {
    labels: userLabels,
    datasets: [{
      label: 'Thống kê đơn hàng theo shipper',
      data: userInfo,
      backgroundColor: [
        'rgb(255, 99, 132)',
        'rgb(54, 162, 235)',
        'rgb(255, 205, 86)'
      ],
      hoverOffset: 4
    }]
  };
  
    const config = {
        type: 'pie',
        data: data,
        options: {
            layout: {
                padding: {
                    bottom: 20
                }
            }
        }
    };
    
    let ctx = document.getElementById(id).getContext("2d")
    
    new Chart(ctx, config)
}
