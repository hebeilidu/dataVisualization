USE [smart]
GO
/****** Object:  Table [dbo].[teaching_situation]    Script Date: 02/03/2022 11:42:15 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[teaching_situation](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[major_name] [varchar](30) NOT NULL,
	[advantage_major] [varchar](255) NOT NULL,
	[set_time] [int] NOT NULL,
	[total_period] [int] NOT NULL,
	[total_credit] [float] NOT NULL,
	[practice_rate] [varchar](12) NOT NULL,
 CONSTRAINT [teaching_situation_pk] PRIMARY KEY NONCLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[student]    Script Date: 02/03/2022 11:42:15 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[student](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[username] [varchar](20) NOT NULL,
	[password] [varchar](32) NOT NULL,
	[major] [varchar](30) NOT NULL,
 CONSTRAINT [PK_student] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[school_situation]    Script Date: 02/03/2022 11:42:15 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[school_situation](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[major_num] [int] NOT NULL,
	[tea_stu_rate] [varchar](12) NOT NULL,
	[degree_rate] [varchar](12) NOT NULL,
	[postdoc_station] [int] NOT NULL,
	[stress_subject] [int] NOT NULL,
 CONSTRAINT [school_situation_pk] PRIMARY KEY NONCLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[personnel_situation]    Script Date: 02/03/2022 11:42:15 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[personnel_situation](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[teacher_num] [int] NOT NULL,
	[teacher_this] [int] NOT NULL,
	[teacher_outer] [int] NOT NULL,
	[teacher_ftime_num] [int] NOT NULL,
	[teacher_ftime_this] [int] NOT NULL,
	[teacher_ftime_outer] [int] NOT NULL,
	[experiment_num] [int] NOT NULL,
	[experiment_title] [int] NOT NULL,
	[experiment_ntitle] [int] NOT NULL,
	[course_num] [int] NOT NULL,
	[course_experiment] [int] NOT NULL,
	[course_theory] [int] NOT NULL,
 CONSTRAINT [table_name_pk] PRIMARY KEY NONCLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[one_major]    Script Date: 02/03/2022 11:42:15 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[one_major](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[major_name] [varchar](255) NOT NULL,
	[student_num] [int] NOT NULL,
	[college] [varchar](255) NOT NULL,
	[teacher_num] [int] NOT NULL,
	[major_code] [varchar](255) NOT NULL,
	[period_num] [int] NOT NULL,
	[credit_num] [int] NOT NULL,
	[title_professor] [int] NULL,
	[title_asprofessor] [int] NULL,
	[title_other] [int] NULL,
	[degree_doctor] [int] NULL,
	[degree_master] [int] NULL,
	[degree_other] [int] NULL,
	[enrollment_planned] [int] NULL,
	[enrollment_actual] [int] NULL,
	[enrollment_first] [int] NULL,
	[enrollment_register] [int] NULL,
	[lab_basic_num] [int] NULL,
	[lab_basic_course] [int] NULL,
	[lab_prof_num] [int] NULL,
	[lab_prof_course] [int] NULL,
	[credit_experiment] [varchar](12) NULL,
	[credit_nexperiment] [varchar](12) NULL,
	[graduate] [int] NULL,
	[graduation_rate] [varchar](12) NULL,
	[employment_rate] [varchar](12) NULL,
	[professors_rate] [float] NULL,
	[Junior_prof_rate] [float] NULL,
	[SeniorTea_rate] [float] NULL,
	[Master's_degree_rate] [float] NULL,
	[tea_under35_rate] [float] NULL,
	[teanum_under35] [int] NULL,
	[teanum_36to45] [int] NULL,
	[teanum_46to55] [int] NULL,
	[teanum_over56] [int] NULL,
	[first_volun_rate] [varchar](30) NULL,
	[registration_rate] [varchar](30) NULL,
	[reqCourse_credits] [int] NULL,
	[eleCourse_credits] [int] NULL,
	[intePractice_credits] [int] NULL,
	[extraActiv_credits] [int] NULL,
 CONSTRAINT [one_major_pk] PRIMARY KEY NONCLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[major_situation]    Script Date: 02/03/2022 11:42:15 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[major_situation](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[major_name] [varchar](30) NOT NULL,
	[establish_time] [int] NOT NULL,
	[teacher] [int] NOT NULL,
	[teacher_foreign] [int] NOT NULL,
	[teacher_senior] [int] NOT NULL,
	[student_bachelor] [int] NOT NULL,
	[student_networth] [int] NOT NULL,
	[graduates] [int] NOT NULL,
	[employment_rate] [float] NOT NULL,
 CONSTRAINT [major_situation_pk] PRIMARY KEY NONCLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[major_leader]    Script Date: 02/03/2022 11:42:15 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[major_leader](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[college] [varchar](50) NOT NULL,
	[major_num] [int] NOT NULL,
	[leader_num] [int] NOT NULL,
	[senior_num] [int] NOT NULL,
	[senior_rate] [varchar](12) NOT NULL,
	[phd_num] [int] NOT NULL,
	[phd_rate] [varchar](12) NOT NULL,
 CONSTRAINT [major_leader_pk] PRIMARY KEY NONCLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[leader_situation]    Script Date: 02/03/2022 11:42:15 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[leader_situation](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[PhD_num] [int] NOT NULL,
	[master_num] [int] NOT NULL,
	[other_num] [int] NOT NULL,
 CONSTRAINT [leader_situation_pk] PRIMARY KEY NONCLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[employment_rate]    Script Date: 02/03/2022 11:42:15 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[employment_rate](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[professional] [varchar](30) NOT NULL,
	[approval_time] [varchar](30) NOT NULL,
	[inteacher_num] [int] NOT NULL,
	[outteacher_num] [int] NOT NULL,
	[highteacher_num] [int] NOT NULL,
	[student_num] [int] NOT NULL,
	[stu_turnover] [float] NOT NULL,
	[fresh_stu_num] [int] NOT NULL,
	[employ_rate] [float] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Employ_recentYears]    Script Date: 02/03/2022 11:42:15 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Employ_recentYears](
	[year] [int] NOT NULL,
	[Grad_emploRate] [float] NULL,
	[Und_emploRate] [float] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[year] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Default [DF__one_major__tea_u__30F848ED]    Script Date: 02/03/2022 11:42:15 ******/
ALTER TABLE [dbo].[one_major] ADD  DEFAULT ((0)) FOR [tea_under35_rate]
GO
