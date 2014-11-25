package com.upcera.ddx.pojo;

import java.util.List;

import com.upcera.ddx.common.util.ToolsKit;

public class PageModel implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/**  
	 * 总记录数  
	 */
	private Long total;
	/**  
	 * 当前页的记录集  
	 */
	private List<?> datas;

	/**  
	 * 当前第几页
	 */
	private Integer offset;

	/**  
	 * 总页数
	 */
	private Long totalPage;
	/**  
	 * 当前页面显示的结果集从第frist条？
	 */
	private Integer frist;
	/**  
	 * 当前页面显示的结果集到第last条？
	 */
	private Integer last;

	public Integer getFrist() {
		return frist;
	}

	public void setFrist(Integer frist) {
		this.frist = frist;
	}

	public Integer getLast() {
		return last;
	}

	public void setLast(Integer last) {
		this.last = last;
	}

	public List<?> getDatas() {
		return datas;
	}

	public void setDatas(List<?> temp) {
		this.datas = temp;
	}

	public Long getTotal() {
		try {
			if(ToolsKit.EmptyCheckUtil.isEmpty(total)){
				return ToolsKit.TypeConversionUtil.asLong(datas.size());
			}
		} catch (Exception e) {
			e.printStackTrace();
			return (long)0;
		}
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public Integer getOffset() {
		return offset;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}

	public Long getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Long totalPage) {
		this.totalPage = totalPage;
	}
	public int getIsmanager() {
		return ismanager;
	}

	public void setIsmanager(int ismanager) {
		this.ismanager = ismanager;
	}
	private int ismanager;
	private int notmanager;

	public int getNotmanager() {
		return notmanager;
	}

	public void setNotmanager(int notmanager) {
		this.notmanager = notmanager;
	}
}
