package com.upcera.ddx.common.cache;

import com.upcera.ddx.common.util.ToolsKit;

public abstract class AbstractCache {

	public abstract void init();
	public abstract void refresh();
	
	public <T> T load(T data) throws Exception {
		if (ToolsKit.EmptyCheckUtil.isEmpty(data)) {
			init();
		}
		return data;
	}
}
