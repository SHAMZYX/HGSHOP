package com.zhaoyuxi.hgshop.util;

/**
 * @author 作者:赵玉玺
 * @version 创建时间：2019年11月16日 上午8:15:32 类功能说明
 */
public class PageUtil {
	/**
	 * 
	 * @param pageNum  当前第几页
	 * @param pages 总页数
	 * @param url   调用的url list?name=12&sex=男&page=3 * @param pageLook 显示多少页
	 * @return
	 */
	public static String page(int pageNum, int pages, String url, int pageLook) {
		if (pageNum < 1)
			pageNum = 1;
		if (pageNum > pages)
			pageNum = pages;
		// 根据url是否参数,改变拼接的符合
		String flag = url.indexOf("?") != -1 ? "&" : "?";
		StringBuilder sb = new StringBuilder();
		sb.append("<nav aria-label='Page navigation example'>");
		// String.format("%1$s%2$s", "abc","123");
		// 'url?page=1' ,url, flag,"page" ,page- 1 < 1 ? 1 : page- 1)
		sb.append(String.format(
				"<ul class='pagination'><li class='page-item'><a class='page-link' style='background-color: rgba(250, 250, 255, 0.3);'  href='%1$s%2$s%3$s=%4$s'aria-label='Previous'>  <span aria-hidden='true'>&laquo;</span></a></li>",
				url, flag, "pageNum", pageNum - 1 < 1 ? 1 : pageNum - 1));
		// 设开始页为1
		int beginPage = 1;
		// 中间页为 pages/2
		int midPage = pageLook / 2;
		if (pageNum > midPage) {
			beginPage = pageNum - midPage;
		}
		for (int i = 0; i < pageLook; i++) {
			// 当前页不加链接
			sb.append(String.format(
					"<li class='page-item'><a  class='page-link'  style='background-color: rgba(250, 250, 255, 0.3);'  href='%1$s%2$s%3$s=%4$s' >%4$s</a></li>",
					url, flag, "pageNum", beginPage + i));
			// 如果后面的页数大于总页数，退出循环
			if (beginPage + i >= pages) {
				break;
			}
		}
		sb.append(String.format(
				"<li class='page-item'><a  class='page-link' style='background-color: rgba(250, 250, 255, 0.3);'  href='%1$s%2$s%3$s=%4$s'  aria-label='Next' ><span aria-hidden='true'>&raquo;</span></a></li>",
				url, flag, "pageNum", pageNum + 1 >= pages ? pages : pageNum + 1));
		sb.append("</ul></nav>");
		return sb.toString();
	}
}
