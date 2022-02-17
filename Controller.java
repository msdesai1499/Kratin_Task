package com.twitt.jobs.controller;

import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.twitt.jobs.dao.UserDao;
import com.twitt.jobs.entities.AddressInformation;
import com.twitt.jobs.entities.AwardsInformation;
import com.twitt.jobs.entities.CertificationInformation;
import com.twitt.jobs.entities.ContactInformation;
import com.twitt.jobs.entities.DocumentInformation;
import com.twitt.jobs.entities.EducationInformation;
import com.twitt.jobs.entities.EmploymentInformation;
import com.twitt.jobs.entities.FamilyInformation;
import com.twitt.jobs.entities.Institute;
import com.twitt.jobs.entities.MedicalInformation;
import com.twitt.jobs.entities.PortfolioInformation;
import com.twitt.jobs.entities.ResearchInformation;
import com.twitt.jobs.entities.ResearchPaperInformation;
import com.twitt.jobs.entities.UserRegistrationAndLogin;
import com.twitt.jobs.services.AddressInfoService;
import com.twitt.jobs.services.AwardsInfoService;
import com.twitt.jobs.services.CertificationInfoService;
import com.twitt.jobs.services.ContactInfoService;
import com.twitt.jobs.services.DocumentInfoService;
import com.twitt.jobs.services.EducationInfoService;
import com.twitt.jobs.services.EmploymentInfoService;
import com.twitt.jobs.services.FamilyInformationService;
import com.twitt.jobs.services.InstituteService;
import com.twitt.jobs.services.MedicalInfoService;
import com.twitt.jobs.services.PortfolioInfoService;
import com.twitt.jobs.services.ResearchInfoService;
import com.twitt.jobs.services.ResearchPaperInfoService;
import com.twitt.jobs.services.SalaryInfoService;
import com.twitt.jobs.services.Services;


@RestController
@CrossOrigin(origins="http://localhost:3000",allowedHeaders="*",allowCredentials = "true")
public class Controller {
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	private Services service;
	
	@Autowired
	private InstituteService instituteService;
	
	@Autowired
	private FamilyInformationService familyInfo;

	@Autowired
	private ContactInfoService contactInfo;
	
	@Autowired
	private EducationInfoService educationInfo;
	
	@Autowired
	private PortfolioInfoService portfolioInfo;
	
	@Autowired
	private MedicalInfoService medicalInfo;
	
	@Autowired
	private ResearchInfoService researchInfo;

	@Autowired
	private AwardsInfoService awardsInfo;
	
	@Autowired
	private CertificationInfoService certificationInfo;
	
	@Autowired
	private ResearchPaperInfoService researchPaperInfo;
	
	@Autowired
	private SalaryInfoService salaryInfo;
	
	@Autowired
	private EmploymentInfoService employmentInfo;
	
	@Autowired
	private DocumentInfoService documentInfo;
	
	@Autowired
	private AddressInfoService addressInfo;
	
	
//	@GetMapping("/res")
//	public String res(HttpSession session) {
//		Long long1= (Long) session.getAttribute("uid");
//		String string=long1.toString();
//		return string;
//	}
	@GetMapping("/user/{id}")
	public UserRegistrationAndLogin getUser(@PathVariable String id) {
		return this.service.getUser(Long.parseLong(id));
				}
	
	//register candidate
	@PostMapping("/register/candidate")
	public String registerUser(@RequestBody UserRegistrationAndLogin user)
	{
		return this.service.registerUser(user);
	}
	
	//retrieve all users from the database
	@GetMapping("/users")
	public List<UserRegistrationAndLogin> getUsers()
	{
		return this.service.getUsers();
	}
	
	@PostMapping("/login/candidates")
	public String loginUser(@RequestBody UserRegistrationAndLogin user,HttpServletRequest request)
	{
		
//			UserRegistrationAndLogin userRegistrationAndLogin=userDao.findByEmailId(user.getEmailId());
//			long uid=userRegistrationAndLogin.getUserId();
//			request.getSession().setAttribute("uid", uid);
			return this.service.loginUser(user);	
	
	}
	
//	@GetMapping("/login/candidate")
//	public String loginUser(@RequestParam(value = "email") String uname  ,@RequestParam(value = "pass") String pass)
//	{
//		return this.service.loginUser(uname,pass);
//	}
	
	//register Institute
	@PostMapping("/register/institute")
	public String registerInstitute(@RequestBody Institute institute) {
		
			return this.instituteService.registerInstitute(institute);
	}
	
	@GetMapping("/institutes")
	public List<Institute> getInstitutes()
	{
		return this.instituteService.getInstitutes();
	}
	
	@GetMapping("/login/institute")
	public String loginInstitute(@RequestBody Institute institute)
	{
		return this.instituteService.loginInstitute(institute);
	}
	
	
	//store family information of user
		@PostMapping("/client/familyInfo")
		public String storeFamilyInfo(@RequestBody FamilyInformation info)
		{
			return this.familyInfo.storeFamilyInformation(info);
		}
		
		//retrieve family information of user by id 
		@GetMapping("/client/familyInfo")
		public FamilyInformation getFamilyInformation(@RequestBody FamilyInformation info)
		{
			return this.familyInfo.getFamilyInformation(info);
		}
		
		
		//store contact information of user
		@PostMapping("/client/contactInfo")
		public String storeContactInfo(@RequestBody ContactInformation info)
		{
			return this.contactInfo.storeContactInfo(info);
		}
		
		
		//get contact information of user using id
		@GetMapping("/client/contactInfo")
		public ContactInformation getContactInfo(@RequestBody ContactInformation info)
		{
			return this.contactInfo.getContactInfo(info);
		}
		
		
		//store address information of user
		@PostMapping("/client/addressInfo")
		public String storeAddressInfo(@RequestBody AddressInformation info)
		{
			return this.addressInfo.storeAddressInfo(info);
		}
		
		//get address information of user using id
		@GetMapping("/client/addressInfo")
		public AddressInformation getAddressInfo(@RequestBody AddressInformation info)
		{
			return this.addressInfo.getAddressInfo(info);
		}
		
		//store education details of user
		@PostMapping("/client/educationDetails")
		public String storeEducationDetails(@RequestBody EducationInformation info)
		{
			return this.educationInfo.storeEducationInfo(info);
		}
		
		//get education details of user by id
		@PostMapping("/client/educationsDetails")
		public List<EducationInformation> getEducationDetails(@RequestBody EducationInformation info)
		{
			return this.educationInfo.getEducationInfo(info);
		}
		
		
		//store portfolio info
		@PostMapping("/client/portfolioInfo")
		public String storePortfolioInfo(@RequestBody PortfolioInformation info)
		{
			return this.portfolioInfo.storePortfolioInfo(info);
		}
		
		//get portfolio info
		@PostMapping("/client/portfolioInfos")
		public List<PortfolioInformation> getPortfolioInfo(@RequestBody PortfolioInformation info)
		{
			return this.portfolioInfo.getPortfolioInfo(info);
		}
		
		//store medical information of user
		@PostMapping("/client/medicalInfo")
		public String storeMedicalInfo(@RequestBody MedicalInformation info)
		{
			return this.medicalInfo.storeMedicalInfo(info);
		}
		
		//get medical information of user using id
		@PostMapping("/client/medicalInfos")
		public MedicalInformation getMedicalInfo(@RequestBody MedicalInformation info)
		{
			return this.medicalInfo.getMedicalInfo(info);
		}
		
		//store research info of user
		@PostMapping("/client/researchInfo")
		public String storeResearchInfo(@RequestBody ResearchInformation info)
		{
			return this.researchInfo.storeResearchInfo(info);
		}
		
		//retrieve research info of user by id 
		@PostMapping("/client/researchInfos")
		public List<ResearchInformation> getResearchInfo(@RequestBody ResearchInformation info)
		{
			return this.researchInfo.getResearchInfo(info);
		}
		
		@PostMapping("/client/awardsInfo")
		public String storeAwardsInfo(@RequestBody AwardsInformation info)
		{
			return this.awardsInfo.storeAwardsInfo(info);
		}
		
		//retrieve awards info of user by id
		@PostMapping("/client/awardsInfos")
		public List<AwardsInformation> getAwardsInfo(@RequestBody AwardsInformation info)
		{
			return this.awardsInfo.getAwardsInfo(info);
		}
	
		
		//store certification info of user
		@PostMapping("/client/certificationInfo")
		public String storeCertificationInfo(@RequestBody CertificationInformation info)
		{
			return this.certificationInfo.storeCertificationInfo(info);
		}
		
		//retrieve certification info of user by id
		@PostMapping("/client/certificationInfos")
		public List<CertificationInformation> getCertificationInfo(@RequestBody CertificationInformation info)
		{
			return this.certificationInfo.getCertificationInfo(info);
		}
		
		//store research paper info
		@PostMapping("/client/researchPaper")
		public String storeResearchPaperInfo(@RequestBody ResearchPaperInformation info)
		{
			return this.researchPaperInfo.storeResearchPaperInfo(info);
		}
		
		//get research paper info
		@GetMapping("/client/researchPaper")
		public ResearchPaperInformation getResearchPaperInfo(@RequestParam("id") long id)
		{
			return this.researchPaperInfo.getResearchPaperInfo(id);
		}
		
		
		//store salary information of user with salary slip file
		@PostMapping("/client/salaryInfo")
		public String storeSalaryInfo(@RequestParam("file") MultipartFile file,@RequestParam("id") long id,@RequestParam("salarymonth") String salaryMonth,@RequestParam("salaryAnnual") String salaryAnnual,@RequestParam("expectedsalary") String expectedSalary)
		{
			try {
				this.salaryInfo.save(file,id,salaryMonth,salaryAnnual,expectedSalary);
				return "Salary details saved successfully";
			}
			catch(Exception e){
				return "Could not save details "+e.getMessage();
			}
		}
		
		@PostMapping("/client/salaryInfoform")
		public String storeSalaryInfo(@RequestParam("id") long id,@RequestParam("salarymonth") String salaryMonth,@RequestParam("salaryAnnual") String salaryAnnual,@RequestParam("expectedsalary") String expectedSalary)
		{
				
				return "Salary details saved successfully "+id;
			
		}
		
		
		//download salary slip by specifying id in url
		@GetMapping("/client/salaryInfo/{id}")
		public ResponseEntity<Resource> getSalarySlip(@PathVariable long id)
		{
			String fileName=this.salaryInfo.getSalarySlip(id);
			Resource file=salaryInfo.load(fileName,id);
			return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,"attachment;filename=\""+file.getFilename()+"\"").body(file);	
		}
		
		
		//store employment details of user along with employment document
		@PostMapping("/client/employmentDetails")
		public String storeEmploymentDetails(@RequestPart MultipartFile file,@RequestParam("userId") long id,@RequestParam("organizationName") String orgName,@RequestParam("typeOfExperience") String expType,@RequestParam("departmentName") String dept,@RequestParam("fromDate") String from,@RequestParam("toDate") String to,@RequestParam("experienceCertificateDate") String expDate)
		{
			try {
				this.employmentInfo.save(file,id,orgName,expType,dept,from,to,expDate);
				return "Employment details saved successfully";
			}
			catch(Exception e){
				return "Could not save details "+e.getMessage();
			}
		}
		
		//get employment details of user by id
		@GetMapping("/client/employmentDetails")
		public List<EmploymentInformation> getEmployeeDetails(@RequestParam("userId") long id)
		{
			return this.employmentInfo.getEmploymentInfo(id);
		}
		
		//pass id and organization name to view the employment document
		@GetMapping("/client/employmentDocuments")
		public ResponseEntity<Resource> getDocument(@RequestParam("userId") long id,@RequestParam("organizationName") String org)
		{
			String fileName=employmentInfo.getEmploymentDocument(id,org);
			Resource file=employmentInfo.load(fileName, id);
			return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,"attachment;filename=\""+file.getFilename()+"\"").body(file);	
		}
		
		
		//store document info of user
		@PostMapping("/client/documentInfo")
		public String storeDocumentInfo(@RequestParam("aadharFile") MultipartFile aadharFile,@RequestParam("panFile") MultipartFile panFile,@RequestParam("licenseFile") MultipartFile licenseFile,@RequestParam("universityFile") MultipartFile universityFile,@RequestParam("userId") long userId,@RequestParam("aadharNo") String aadharNo,@RequestParam("panNo") String panNo,@RequestParam("drivingLicenseNo") String licenseNo,@RequestParam("universityApprovalNo") String uniApprovalNo,@RequestParam("approvalType") String approvalType,@RequestParam("dateOfIssued") String dateOfIssued,@RequestParam("casteValidity") boolean casteValidity,@RequestParam("passportNumber") String passportNo)
		{
			try {
				this.documentInfo.save(aadharFile, panFile,licenseFile, universityFile,userId, aadharNo, panNo, licenseNo, uniApprovalNo, approvalType,dateOfIssued, casteValidity,passportNo);
				return "Documents saved successfully";
			}
			catch(Exception e){
				return "Could not save details "+e.getMessage();
			}
		}
		
		//get document info of user by id
		@GetMapping("/client/documentInfo")
		public DocumentInformation getDocumentInfo(@RequestParam("userId") long id)
		{
			return this.documentInfo.getDocumentInfo(id);
		}
		
		//get particular document by file type i.e aadhar/pan/license,etc 
		@GetMapping("/client/documents")
		public ResponseEntity<Resource> getDocumentByFileType(@RequestParam("userId") long id,@RequestParam("fileType") String fileType)
		{
			String fileName=documentInfo.getDocument(id, fileType);
			Resource file=documentInfo.load(fileName, id);
			return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,"attachment;filename=\""+file.getFilename()+"\"").body(file);	
		}	
		
		
		//change user password
		@PutMapping("/client/changePassword")
		public String changePassword(@RequestParam("id")long id,@RequestParam("currPass") String currPass,@RequestParam("newPass") String newPass)
		{
			return this.service.changePassword(id,currPass,newPass);
		}
		
}
