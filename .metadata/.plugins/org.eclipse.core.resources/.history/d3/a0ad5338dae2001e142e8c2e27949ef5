package my.com.cmg.iwp.webui.util;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Component;
import java.awt.Window;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.http.HttpClient;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.Id;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.lang.StringUtils;
import org.hibernate.Session;
import org.joda.time.PeriodType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.zkoss.spring.SpringUtil;
import org.zkoss.util.resource.Labels;
import org.zkoss.zk.ui.Execution;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zul.Bandbox;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Decimalbox;
import org.zkoss.zul.Doublebox;
import org.zkoss.zul.FieldComparator;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listhead;
import org.zkoss.zul.Listheader;
import org.zkoss.zul.Longbox;
import org.zkoss.zul.Paging;
import org.zkoss.zul.Radio;
import org.zkoss.zul.Radiogroup;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Toolbarbutton;

import com.googlecode.genericdao.search.Sort;

import my.com.cmg.iwp.UserWorkspace;
import my.com.cmg.iwp.maintenance.model.CBMaster;
import my.com.cmg.iwp.maintenance.model.ExternalFacility;
import my.com.cmg.iwp.maintenance.model.RefCodes;
import my.com.cmg.iwp.maintenance.model.SecUser;
import my.com.cmg.iwp.maintenance.model.SimpleBean;
import my.com.cmg.iwp.maintenance.service.RefCodesService;
import my.com.cmg.iwp.maintenance.service.UserService;
import my.com.cmg.iwp.webui.common.CommonBandpopup;
import my.com.cmg.iwp.webui.constant.HQConstants;
import my.com.cmg.iwp.webui.constant.RefCodeConstant;
import my.com.cmg.iwp.webui.dashboard.TaskListCtrl;
import my.com.cmg.iwp.webui.util.pagging.PagedListWrapper;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRPrintPage;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.type.OrientationEnum;

@SuppressWarnings(value = { "unchecked", "rawtypes" })
public class CommonUtil {
	public static final String SERVICE_TYPE_REQUEST = "REQUEST";
	public static final String SERVICE_TYPE_RESULT = "RESULT";
	public static void setComboboxValue(Combobox combobox, Object id) {
		List<Comboitem> items = combobox.getItems();
		for (Comboitem item : items) {
			if (id.toString().trim().equals(item.getValue().toString().trim())) {
				combobox.setSelectedItem(item);
				break;
			}
		}
	}

	public static void setComboboxValueInvisible(Combobox combobox, long id) {
		List itemList = combobox.getChildren();
		List<Comboitem> items = itemList;
		for (Comboitem item : items) {
			Long val = item.getValue();
			if (String.valueOf(val).equalsIgnoreCase(String.valueOf(id))) {
				item.setVisible(false);
				break;
			}
		}
	}

	/**
	 * @deprecated Datebox format would be set automatically by BaseComposer before render
     */
	@Deprecated
	public static void setPageDateFormater(Component component) {}

	public static void populateCombobox(List<RefCodes> refCodeList, Combobox comb) {
		comb.getItems().clear();
		if (refCodeList != null && refCodeList.size() > 0) {
			for (RefCodes refCode : refCodeList) {
				Comboitem item = new Comboitem();
				item.setLabel(refCode.getRcDesc());
				item.setValue(refCode.getRcValue());
				item.setParent(comb);
			}
		}
	}

	public static void populateCombobox_WithAllValue(List<RefCodes> refCodeList,
			Combobox comb) {
		
		comb.getItems().clear();
		
		RefCodes refCodeAll = new RefCodes();
		refCodeAll.setRcDesc("All");
		refCodeAll.setRcValue("All");
		refCodeList.add(0, refCodeAll);

		if (refCodeList != null && refCodeList.size() > 0) {
			for (RefCodes refCode : refCodeList) {
				Comboitem item = new Comboitem();
				item.setLabel(refCode.getRcDesc());
				item.setValue(refCode.getRcValue());
				item.setParent(comb);
			}
		}
	}

	public static void populateComboboxRefCodes(List<RefCodes> refCodeList,
			Combobox comb) {


		if (refCodeList != null && refCodeList.size() > 0) {
			for (RefCodes refCode : refCodeList) {
				Comboitem item = new Comboitem();
				item.setLabel(refCode.getRcDesc());
				item.setValue(refCode);
				item.setParent(comb);
			}
		}
	}
	
	public static void selectComboitemByValue(Combobox cb, String value) {
		for (int i = 0; i < cb.getItemCount(); i++) {
			Comboitem ci = cb.getItemAtIndex(i);
			if (((String) ci.getValue()).equalsIgnoreCase(value)) {
				cb.setSelectedIndex(i);
				cb.setSelectedItem(ci);
				break;
			}
		}
	}

	public static void populateCombobox(List<RefCodes> refCodeList,
			Combobox comb, String val) {
		if (refCodeList != null && refCodeList.size() > 0) {
			for (RefCodes refCode : refCodeList) {
				Comboitem item = new Comboitem();
				item.setLabel(refCode.getRcDesc());
				item.setValue(refCode.getRcValue());
				item.setParent(comb);
				if (val != null && refCode.getRcValue().equals(val)) {
					comb.setSelectedItem(item);
				}
			}
		}
	}

	// lwh 20121101
	public static boolean time24HoursValidator(String theTime) {
		Pattern pattern = Pattern.compile("([01][0-9]|2[0-3]):[0-5][0-9]");
		Matcher matcher = pattern.matcher(theTime);
		// System.out.println(theTime + " - "+matcher);
		// System.out.println(theTime + " - "+matcher.matches());
		return matcher.matches();
	}

	public static SecUser getCurrentSecUser() {
		String userName = SecurityContextHolder.getContext()
				.getAuthentication().getName();
		UserService userService = (UserService) SpringUtil
				.getBean("userService");
		return userService.getUserByLoginname(userName);
	}

	public static String getPkProperty(Class clazz) {
		Method[] methods = clazz.getDeclaredMethods();
		for (Method method : methods) {
			String methodName = method.getName();
			if (methodName.startsWith("get")) {
				Annotation[] annotations = method.getAnnotations();
				for (Annotation annotation : annotations) {
					if (annotation instanceof Id) {
						 String propertyName = methodName.substring(3);
						 return StringUtils.uncapitalize(propertyName);
					}
				}
			}
		}
		return null;
	}

	public static void doCheckRightsForContainerButtons(Component container,UserWorkspace workSpace){
		if(container == null){
			return;
		}		
		Collection<Component> allCoponents = container.getFellows();
		for (Component component : allCoponents) {
			if(component instanceof Button && !(component instanceof Toolbarbutton)){
				System.out.println(component.getId());
				component.setVisible(workSpace.isAllowed(component.getId()));
			}
			if(component instanceof Combobox){
				Combobox combobox = (Combobox) component;
				combobox.setMold("rounded");
			}
			if(component instanceof Datebox){
				Datebox combobox = (Datebox) component;
				combobox.setMold("rounded");
			}
			if(component instanceof Bandbox){
				Bandbox combobox = (Bandbox) component;
				combobox.setMold("rounded");
			}
		}
		System.out.println("_______________________________");
	}
	/**
	 * This Method used to calculate patient age
	 * @param dateOfBirth
	 * @return int
	 */
	public static String getTotalAge(Date birthDate) {
		String age = "";
		LocalDate dob = new LocalDate(birthDate);
        LocalDate date = new LocalDate(new Date());

        Period period = new Period(dob, date, PeriodType.yearMonthDay());
        age = period.getYears() + " Years " +  period.getMonths() + " Months "+ period.getDays() + " Days";
		return age;
	}
	
	public static int getTotalAgeInYear(Date birthDate) {
//		String age = "";
		LocalDate dob = new LocalDate(birthDate);
        LocalDate date = new LocalDate(new Date());

        Period period = new Period(dob, date, PeriodType.yearMonthDay());
        return period.getYears();
        
	}
	
	
	
	
	public static void openReport(Map<Object, Object> params, Collection<?> beans, String report) {
		Window window = (Window)Executions.createComponents("/WEB-INF/reports/reportZul.zul", null, null);
		window.setAttribute("REPORT_PATH", report);
		window.setAttribute("PARAMETERS_MAP", params);
		window.setAttribute("BEANLIST", beans);
		window.doModal();
	}
	
	public static void printReport(Map<String,Object> params, Collection<?> beans, String report, Component component) throws Exception {
		Execution exec = Executions.getCurrent();
		InputStream is = exec.getDesktop().getWebApp().getResourceAsStream(exec.toAbsoluteURI(report, false));
		JasperPrint jasperPrint = JasperFillManager.fillReport(is, params, (beans == null ? new JREmptyDataSource() : new JRBeanCollectionDataSource(beans)));
		jasperPrint.setOrientation(OrientationEnum.PORTRAIT);		
		JasperPrint  jasperPrint2 = jasperPrint;
		
		List<JRPrintPage> pages = new ArrayList<JRPrintPage>( jasperPrint2.getPages());
		int i=1;
		for(int count=0;count<pages.size();count++){
			jasperPrint.addPage(i, (JRPrintPage)pages.get(count));
			i++;
		}
				
		Applet applet = new Applet();
		applet.setCodebase("/applet");
		applet.setArchive("ReportApplet.jar");
		applet.setCode("my.com.cmg.phis.webui.util.ReportApplet");
		applet.setWidth("0");
		applet.setHeight("0");
		applet.setParam("jasperPrint", JasperExportManager.exportReportToXml(jasperPrint));
		component.appendChild(applet);
	}
	
	/**
	 * Src: http://forum.zkoss.org/question/79193/component-query-by-tagname-or-component-type/
	 **/
	private static <T extends Component> List<T> find(Class<T> clazz, Component parent, int depth, boolean exitOnFirst) {
        List<T> comps = new ArrayList<T>();
        int nextDepth = depth - 1;
        List<Component> children = parent.getChildren();
        for (Iterator<Component> iterator = children.iterator(); iterator.hasNext(); ) {
            Component child = iterator.next();
            if (child.getClass().getName().equals(clazz.getName())) {
                comps.add((T) child);
                if (exitOnFirst) {
                    break;
                }
            }
            if (nextDepth > 0) {
                comps.addAll(find(clazz, child, nextDepth, exitOnFirst));
            }
        }
        return comps;
    }

    public static <T extends Component> List<T> find(Class<T> clazz, Component parent, int depth) {
        return find(clazz, parent, depth, false);
    }

    public static <T extends Component> T findFirst(Class<T> clazz, Component parent, int depth) {
        List<T> t = find(clazz, parent, depth, true);
        if (t.size() > 0)
            return t.get(0);
        return null;
    }
    
    public static <T> T getService(String bean) {
    	return (T)SpringUtil.getBean(bean);
    }
    
    public static void populateListheaders(Listbox listbox, String... displayProperties) {
    	if(listbox.getListhead() != null) {
    		listbox.removeChild(listbox.getListhead());
    	}
    	
		Listhead listhead = new Listhead();
		listhead.setParent(listbox);
		
		for (String displayProperty : displayProperties) {
			Listheader listheader = new Listheader();
			listheader.setSort("auto");
			listheader.setWidth(displayProperties.length > 10 ? "100px" : ((double)100 / displayProperties.length) + "%");
			listheader.setLabel(Labels.getLabel(listbox.getId() + "." + displayProperty, listbox.getId() + "." + displayProperty));
			listheader.setSortAscending(new FieldComparator(displayProperty, true));
			listheader.setSortDescending(new FieldComparator(displayProperty, false));
			listheader.setParent(listhead);
		}
    }

    public static void populateCombobox(Combobox combobox, List<?> objects, Object defaultObject, String labelField, String valueField, boolean hasAllItem) throws Exception {
		combobox.getItems().clear();
		
		Comboitem comboitem;
		
		if(hasAllItem) {
			comboitem = new Comboitem();
			comboitem.setLabel("All");
			comboitem.setValue(null);
			comboitem.setParent(combobox);
			
			if(defaultObject == null) {
				combobox.setSelectedItem(comboitem);
			}
		}

		for (Object object : objects) {
			String currentLabel = StringUtils.isBlank(labelField) ? object.toString() : ReflectionUtil.getReflectionFieldName(object, labelField).toString();
			Object currentValue = valueField == null ? object : ReflectionUtil.getReflectionFieldName(object, valueField);
			Object defaultValue = defaultObject == null ? null : ReflectionUtil.getReflectionFieldName(defaultObject, valueField);
			
			comboitem = new Comboitem();
			comboitem.setLabel(currentLabel);
			comboitem.setValue(currentValue);
			comboitem.setParent(combobox);
			
			if(currentValue.equals(defaultValue)) {
				combobox.setSelectedItem(comboitem);
			}
		}
	}
	
	public static void populateCombobox(Combobox combobox, String domain, String defaultValue, Boolean asc, boolean hasAllItem) throws Exception {
		
		RefCodesService refCodeService = CommonUtil.getService("refCodesService");
		List<RefCodes> refCodes = new ArrayList<RefCodes>();
		if(asc == null) {
			refCodes = refCodeService.getRefCodesByDomain(domain);
		} else if (asc == true) {
			refCodes = refCodeService.getAscOrderbySeqNo(domain);
		} else {
			refCodes = refCodeService.getDescOrderbySeqNo(domain);
		}
		
		populateCombobox(combobox, refCodes, refCodeService.getRefCodeByRcValue(domain, defaultValue), "rcDesc", "rcValue", hasAllItem);
	}
	
	public static void populateCombobox(Combobox combobox, String domain, String defaultValue, Boolean asc, String sortProperty, boolean hasAllItem) throws Exception {
		RefCodesService refCodeService = CommonUtil.getService("refCodesService");
		List<RefCodes> refCodes = new ArrayList<RefCodes>();
		refCodes = refCodeService.getAscOrderbySeqNo(domain, sortProperty);
		populateCombobox(combobox, refCodes, null, "rcDesc", "rcValue", hasAllItem);
	}
	
	public static float getBmiValue(BigDecimal height, BigDecimal weight)throws Exception {		
		return weight.floatValue()/ ((height.floatValue() / 100) * (height.floatValue() / 100));
	}

	public static double getBsaValue(BigDecimal height, BigDecimal weight)throws Exception {
		
		return  0.0003207 * Math.pow(height.floatValue(), 0.3)* Math.pow(weight.floatValue() * 1000, (0.7285 - (0.0188 * Math.log10(weight.floatValue() * 1000))));// Boyd Fomula
	}
	
	public static Character toCharacter(String statusValue) {
		return (statusValue != null) ? statusValue.charAt(0) : null;
	}
	
	public static Character toCharacter(Boolean flag) {
		if(flag){
			return RefCodeConstant.BOOLEAN_TRUE;
		}else{
			return RefCodeConstant.BOOLEAN_FALSE;
		}
	}
	
	public static String toYesNo(Character flag) {
		if(flag == null) return "N/A";
		else if(RefCodeConstant.ACTIVE_FLAG_TRUE.equals(flag) || RefCodeConstant.BOOLEAN_TRUE.equals(flag)) return RefCodeConstant.COMMON_YES;
		else if(RefCodeConstant.ACTIVE_FLAG_FALSE.equals(flag) || RefCodeConstant.BOOLEAN_FALSE.equals(flag)) return RefCodeConstant.COMMON_NO;
		else return "N/A";
	}

	public static Character toAICharacter(boolean flag) {
		return flag ? RefCodeConstant.ACTIVE_FLAG_TRUE : RefCodeConstant.ACTIVE_FLAG_FALSE;

	}

	/// Phan: utility function to convert Character to Boolean
	public static Boolean toBoolean(Character flag) {
		if (flag == null) {
			return false;
		} else {
			if(RefCodeConstant.ACTIVE_FLAG_TRUE.equals(flag) || RefCodeConstant.BOOLEAN_TRUE.equals(flag)) {
				return true;
			} else if(RefCodeConstant.ACTIVE_FLAG_FALSE.equals(flag) || RefCodeConstant.BOOLEAN_FALSE.equals(flag)) {
				return false;
			} else {
				// not supported right now
				return null;
			}
		}
	}
	
	public static void doChangeDisplayAttr(boolean readonly,Radiogroup... radioGroups) {
		for (Radiogroup radioGroup : radioGroups){
			List<Radio> radios = radioGroup.getItems(); 
			for (Radio radio : radios) {
				radio.setDisabled(readonly);
			}
		}
	}
	
	/**
	 * @param bb_vote_code
	 * @throws Exception
	 */
	public static void populateBBVoteCode(Bandbox bb_vote_code,Integer financialYear) throws Exception {
		CommonBandpopup commonBandpopup = new CommonBandpopup(bb_vote_code, CBMaster.class);
		commonBandpopup.setSearchProperties("voteCode.voteName","voteCode.voteCode");
		commonBandpopup.setLabelKey("VoteCodeDescription");
		commonBandpopup.setDisplayProperties("voteCode.voteName","voteCode.voteCode","budgetType");
		commonBandpopup.setRefCodeProperties(new SimpleBean("budgetType", RefCodeConstant.BUDGET_TYPE));
		commonBandpopup.setHiddenProperties(Filter.equal("activeFlag", RefCodeConstant.ACTIVE_FLAG_TRUE),Filter.equal("financialYear", financialYear));
		commonBandpopup.setSortProperties(new Sort("voteCode.voteName", true),new Sort("voteCode.voteCode", false),new Sort("budgetType", false));
		commonBandpopup.render();
	}
	
	public static void setPaging(Paging paging, Listbox listbox, int size,int pageSize) {
	    listbox.invalidate();
	    paging.invalidate();
	    paging.setPageSize(pageSize);
	    paging.setTotalSize(size);
	    paging.setAutohide(false);
	    paging.setDetailed(true);
	    paging.setActivePage(0);
	    listbox.setMold("paging");
	    listbox.setPagingPosition("top");
	    listbox.setPaginal(paging);
	}
	
	public static void populateBbActiveExternalFacility(Bandbox bandbox, Filter ...filters ) throws Exception {
		CommonBandpopup commonBandpopup = new CommonBandpopup(bandbox, ExternalFacility.class);
		commonBandpopup.setSearchProperties("facilityName", "facilityCode","state");
		commonBandpopup.setDisplayProperties("facilityName", "facilityCode","state");
		commonBandpopup.setRefCodeProperties(new SimpleBean("state", RefCodeConstant.STATE_MY));
		commonBandpopup.setSortProperties(new Sort("facilityName", false));
		commonBandpopup.setHiddenProperties(filters);
		commonBandpopup.render();
    }
	
	public static void populateCombobox(Combobox combobox, List<?> objects, Object defaultObject, String labelField, String valueField, boolean hasAllItem, boolean hasEmpty) throws Exception {
		populateCombobox(combobox, objects, defaultObject, labelField, valueField, hasAllItem);
		Comboitem comboitem;
		if (hasEmpty) {
			comboitem = new Comboitem();
			comboitem.setLabel(" ");
			comboitem.setValue(null);
			comboitem.setParent(combobox);
		}
	}

	static RefCodesService refCodesService = (RefCodesService) SpringUtil.getBean("refCodesService");
	public static Listcell getStatusListItem(Character status) {
		Listcell lc;
		if (RefCodeConstant.STATUS_VALUE_ACTIVE.charAt(0) == status) {
			lc = new Listcell(refCodesService.getRefCodeByRcValue(RefCodeConstant.STATUS,RefCodeConstant.STATUS_VALUE_ACTIVE).getRcDesc());
		} else {
			lc = new Listcell(refCodesService.getRefCodeByRcValue(RefCodeConstant.STATUS,RefCodeConstant.STATUS_VALUE_INACTIVE).getRcDesc());
			lc.setClass("inactiveListcell");
		}
		lc.setStyle("text-align: left");
		return lc;
	}
	
	public static void doRefreshTaskList(Component component){		
		if(component != null ){
			System.out.println("from common util --------------------- : TASKLIST_CONTROLLER"+component.getDesktop().getId() + " --------------- " + component.getId() + " -- " + component.getUuid());
			TaskListCtrl taskListCtrl = (TaskListCtrl) Sessions.getCurrent().getAttribute("TASKLIST_CONTROLLER"+component.getDesktop().getId());
			if(taskListCtrl != null)
				taskListCtrl.doRefresh();
		}
	}

	public static void doSetReadonlyComponents(boolean flag, Component... components) throws Exception {
		for (Component component : components) {
			if (component instanceof Combobox) {
				((Combobox) component).setDisabled(flag);
			}else if (component instanceof Datebox) {
				((Datebox) component).setDisabled(flag);
			}else if (component instanceof Intbox) {
				((Intbox) component).setReadonly(flag);
			}else if (component instanceof Decimalbox) {
				((Decimalbox) component).setReadonly(flag);
			}else if (component instanceof Longbox) {
				((Longbox) component).setReadonly(flag);
			}else if (component instanceof Doublebox) {
				((Doublebox) component).setReadonly(flag);
			}else if(component instanceof Checkbox) {
				((Checkbox) component).setDisabled(flag);
			}else if(component instanceof Bandbox) {
				((Bandbox) component).setDisabled(flag);
			}else if (component instanceof Textbox) {
				((Textbox) component).setReadonly(flag);
			}
		}
	}
	
	public static void closeSession(Session session) {
		if (session != null && session.isOpen()) {
			session.close();
		}
	}
	
	public static boolean isPing(final String host)  {
		if (StringUtils.isEmpty(host)) {
			return false;
		}
		try {
			InetAddress inetAddress = InetAddress.getByName(host);
			if (inetAddress.isReachable(5000)) {
				System.out.println("Ping Successful  host name : "+host);
				return true;
			} else {
				System.out.println("Ping Failure  host name : "+host);
				return false;
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return false;
	}
	
	private static final String GET_RECEIVE_DATA = "PhISService/GetReceiving";
	public static String getUriPhISService(ExternalFacility extFac,  String lpoNo) throws SQLException {	
		StringBuffer uri = null;
		try {
			uri = new StringBuffer("http://").append(extFac.getServerIp())
					.append(StringUtils.isEmpty(extFac.getServerPort()) ? "" : ":" + extFac.getServerPort())
					.append("/")
					.append(GET_RECEIVE_DATA)
					.append("?LPO="+lpoNo);
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return uri.toString();
	}
	
	/**
	 * Get Delivery order Details from Facility by Facility Code and LPO No
	 * @param URL
	 * @return
	 * @throws HttpException
	 * @throws IOException
	 */
	public static String getFromFacility(String URL) throws HttpException, IOException {		
		String result = "";
		HttpClient client = new HttpClient();
		GetMethod getMethod = new GetMethod(URL);
		int statusCode = client.executeMethod(getMethod);
		if (statusCode != HttpStatus.SC_OK) {
			System.out.println("Method failed: " + getMethod.getStatusLine());
		}
		// Get the response body
		result = getMethod.getResponseBodyAsString();
		System.out.println("Result XML : "+result);
		return result;		
	}
	
	/**
	 * Parses the incoming XML file String and Send back the Document Object to
	 * caller
	 * 
	 * @param xmlString
	 * @return
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	public static Document convertStringToDocument(String xmlString)
			throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory docFactory = DocumentBuilderFactory
				.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		InputSource is = new InputSource(new StringReader(xmlString));
		Document document = docBuilder.parse(is);
		document.getDocumentElement().normalize();
		return document;
	}
	
	public static Date getDODateTime(String oDate) throws Exception{
        SimpleDateFormat oDf = getFormatter("dd/MM/yyyy");    
        return oDf.parse(oDate);
    }
	
	public static Date getDODatewithTime(String oDate) throws Exception{
        SimpleDateFormat oDf = getFormatter("dd/MM/yyyy HH:mm:ss");    
        return oDf.parse(oDate);
    }
	private static HashMap cachedFormatter=new HashMap();
	private synchronized static SimpleDateFormat getFormatter(String pattern){
        SimpleDateFormat oFormatter;
        if ( cachedFormatter.containsKey(pattern)){
            oFormatter =  (SimpleDateFormat) cachedFormatter.get(pattern);
        }else{
            oFormatter = new SimpleDateFormat(pattern);
            cachedFormatter.put(pattern,oFormatter);
        }
        return oFormatter;                
    }
	
	public static boolean validateEmail(String email) {
		final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}
	
	public static void populateComboboxForSelectLabelByDefault(Combobox combobox, String domain, String defaultValue, Boolean asc) throws Exception {
		RefCodesService refCodeService = CommonUtil.getService("refCodesService");
		List<RefCodes> refCodes = new ArrayList<RefCodes>();
		if (asc == null) {
			refCodes = refCodeService.getRefCodesByDomain(domain);
		} else if (asc == true) {
			refCodes = refCodeService.getAscOrderbySeqNo(domain);
		} else {
			refCodes = refCodeService.getDescOrderbySeqNo(domain);
		}
		RefCodes refCode = refCodeService.getRefCodeByRcValue(domain, defaultValue);
		populateComboboxForSelectLableByDefault(combobox, refCodes, refCode, "rcDesc", "rcValue");
	}
	
	public static void populateComboboxForSelectLableByDefault(Combobox combobox, List<?> objects, Object defaultObject, String labelField,
			String valueField) throws Exception {
		combobox.getItems().clear();

		Comboitem comboitem;

		for (Object object : objects) {

			String currentLabel = StringUtils.isBlank(labelField) ? object.toString()
					: ReflectionUtil.getReflectionFieldName(object, labelField) != null
							? ReflectionUtil.getReflectionFieldName(object, labelField).toString() : "";
			Object currentValue = valueField == null ? object
					: ReflectionUtil.getReflectionFieldName(object, valueField);
			Object defaultValue = defaultObject == null || valueField == null ? null
					: ReflectionUtil.getReflectionFieldName(defaultObject, valueField);
			currentLabel = getConvertUnicodeValues(currentLabel);
			comboitem = new Comboitem();
			comboitem.setLabel(currentLabel);
			comboitem.setValue(currentValue);
			comboitem.setParent(combobox);
			if (currentValue.equals(defaultValue)) {
				combobox.setSelectedItem(comboitem);
			}
		}
		
		comboitem = new Comboitem();
		comboitem.setLabel("-Select-");
		comboitem.setValue(null);
		comboitem.setParent(combobox);
		if (combobox.getSelectedItem() != null) {
			combobox.setSelectedItem(comboitem);
		}		
	}
	
	private static String getConvertUnicodeValues(String currentLabel) {
		String returnVal = currentLabel.replaceAll("&deg;", "°").replaceAll("&micro;", "µ");
		return returnVal;
	}
	
	public static Connection getRepoConnection(HashMap<String,String> connectionMap) {
		 String url = (String) connectionMap.get("repoUrl");
		 String	dbuser = (String) connectionMap.get("repoUser");
		 String password = (String) connectionMap.get("repoPassword");
	        Connection con = null;
	        try {
	            Class.forName("oracle.jdbc.driver.OracleDriver");
	            con = DriverManager.getConnection(url,dbuser, password);
	        } catch (ClassNotFoundException cnf) {
	           // logger.error("getConnection() :", cnf);
	            cnf.printStackTrace();
	        } catch (SQLException sq) {
	            //logger.error("getConnection() :", sq);
	            sq.printStackTrace();
	        }
	        return con;
	    }
	 
	 public static HashMap<String,String> getRepoInfo(HashMap<String,String> connectionMap) {
			try {
				Properties properties = getProperties();
				connectionMap.put("repoUrl", properties.getProperty("jdbc.url"));
				connectionMap.put("repoUser", properties.getProperty("jdbc.username") );
				connectionMap.put("repoPassword", properties.getProperty("jdbc.password"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return connectionMap;
			
		}
	 public static void refreshTOPage(PagedListWrapper plw, Listbox listbox, Paging paging, int toPage) {
			// while(toPage > paging.getPageCount()) --toPage;
			while (((toPage + 1) * paging.getPageSize()) > (paging.getPageCount() * paging.getPageSize()))
				--toPage;
			paging.setActivePage(toPage);
			int active = paging.getActivePage();
			int size = paging.getPageSize();
			plw.refreshModel(active * size);
		}
	 
	 public static Properties getProperties() throws Exception {
	        InputStream in = null;
	        Properties props = new Properties();
	        String filename=HQConstants.REPO_CONFIG_PATH;
	        try {			
		        in = new FileInputStream(filename);
		        props.load(in);
		        return props;
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				try {				
					in.close();
				} catch (Exception e) {	}
			}
	        return null;
	    }

}
