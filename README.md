

主要用于个人复习。


## 每日笔记

2018.8.19：

今天主要是新增图片后返回码的处理.

因为之前上传图片后，是直接返回刷新上传页面，所以这次可以直接在上传时添加判断，方便后续操作

``` HTML
if(adService.add(adDto)){
		
		}else{
			
		}
```

然后为了方便我们可以用枚举（10：新增 00：成功 01：失败四位表示）来处理返回码。然后主要成员为code和msg。构造方法采用默认，外部不能调用（同包子类（继承）和不同包非子类（对象））。
``` HTML
  private Integer code;
	private String msg;
	
	private PageCodeEnum(Integer code,String msg) {
		this.code=code;
		this.msg=msg;
	}
```

接着定义一个KEY告诉页面传的是啥，然后传值给页面需要一个Model对象，调用addAttribute(PageCodeEnum.KEY,PageCodeEnum.ADD_SUCCESS);//这是一个成功示例  当然这里是一个最简单的示例，毕竟还有Service。

然后是前端展示。写一个JS方法。当有msg传入时，alert。所以也需要在jsp设置一个hidden文本接收，用el表达式取值。
``` HTML
<input type="hidden" id="message" value="${pageCode.msg}"/>
```

最后是JS的一点小笔记
``` HTML
$(function() {
	common.showMessage($("#message").val());
});
******************************************************
var common = window.common || {}; // window.common || 防止插件与自定义命名空间重名而bug

/**
 * 展示指定的消息内容。
 */
common.showMessage = function(msg) {
	if(msg) {
		alert(msg);
	}
}
```

