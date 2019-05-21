
/**
 * PageResult分页插件
 *  代码不全，仅供参考
 */

/**
 * @author ZhangFen
 * @date 2018年8月10日  下午3:26:21
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ImgPageVO  extends PageResult<ImgVO>{
	private static final long serialVersionUID = 1L;
	private int  total;         //总页码
	private int  page; 			//当前页码
	private int  records;	    //总条数
	private List<ImgVO> rows;
}

/**
 * @author ZhangFen
 * @date 2018年8月10日  下午6:24:18
 */
@Data
@EqualsAndHashCode
public class ImgVO implements Serializable{
	private static final long serialVersionUID = 1L;

    private Integer systemId;
    
    private String materialName;
    
    private String materialUriPath;
    
    private String materialThumUriPath;   
}

/**
 * 根据系统id查询素材库中图片信息
 * @param systemId
 * @param req
 * @return
 */
@RequestMapping("/{systemId}/searchCmsMaterial.json")
@ResponseBody
public ImgPageVO  searchCmsMaterial(@PathVariable("systemId")Integer systemId,
		HttpServletRequest req){
	
	CmsMaterialPageRequest cmsMaterialPageRequest = new CmsMaterialPageRequest();
	String pageNum = StringUtils.trimToEmpty(req.getParameter("page"));		  //当前页码
	String pageSize = StringUtils.trimToEmpty(req.getParameter("rows"));  //页数量
	//String total = StringUtils.trimToEmpty(req.getParameter("total")); 		//总页数
	//String records=request.getParameter("records");	    //总记录数
	//cmsMaterialPageRequest.setAlbumId("article");
	String materialName = StringUtils.trimToEmpty(req.getParameter("materialName")); //素材名称
	String useScene = StringUtils.trimToEmpty(req.getParameter("useScene")); 		 //应用场景
	cmsMaterialPageRequest.setMaterialName(materialName);
	cmsMaterialPageRequest.setUseScene(Integer.valueOf(useScene));
	cmsMaterialPageRequest.setSystemId(systemId);
	cmsMaterialPageRequest.setPageNo(Integer.valueOf(pageNum));
	cmsMaterialPageRequest.setPageSize(Integer.valueOf(pageSize));
	ImgPageVO imgPageVO=cmsMaterialApiService.queryCmsImgPageList(cmsMaterialPageRequest);		
	return imgPageVO;
}