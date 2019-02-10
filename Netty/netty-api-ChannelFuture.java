--------------------------------
ChannelFuture					|
--------------------------------
	# interface ChannelFuture extends Future<Void>
	# 事件的回调


--------------------------------
方法							|
--------------------------------
	Channel channel();
		* 返回关联的channel

    @Override
    ChannelFuture addListener(GenericFutureListener<? extends Future<? super Void>> listener);
		* 添加一个监听

    @Override
    ChannelFuture addListeners(GenericFutureListener<? extends Future<? super Void>>... listeners);
		* 添加多个监听

    @Override
    ChannelFuture removeListener(GenericFutureListener<? extends Future<? super Void>> listener);
		* 移除一个监听

    @Override
    ChannelFuture removeListeners(GenericFutureListener<? extends Future<? super Void>>... listeners);
		* 移除多个监听

	ChannelFuture sync()
