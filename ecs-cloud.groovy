import jenkins.*;
import jenkins.model.*;
import hudson.*;
import hudson.model.*;
import com.cloudbees.jenkins.plugins.amazonecs.*;

// source: https://github.com/jenkinsci/amazon-ecs-plugin
// based on: https://github.com/myoung34/docker-jenkins/blob/master/jenkins/ecs.groovy

def regionName = "us-east-1"
def jenkinsUrl = "http://jenkins.local"
def cloudName = "mycloud"
def cloudCredentialsId = null
def cloudClusterName = null
def image = "jenkinsci/jnlp-slave"

def instance = Jenkins.instanceOrNull

def taskTemplate = new ECSTaskTemplate(
  templateName="jnlp-slave-with-docker",
  label="ecs docker any ec2-deploy ec2 deploy",
  taskDefinitionOverride=null,
  image=image,
  repositoryCredentials=null,
  launchType="EC2",
  networkMode="foo",
  remoteFSRoot="/var/jenkins_home",
  memory=0,
  memoryReservation=0,
  cpu=0,
  subnets=null,
  securityGroups=null,
  assignPublicIp=false,
  privileged=false,
  containerUser=null,
  logDriverOptions=null,
  environments=null,
  extraHosts=null,
  mountPoints=null,
  portMappings=null,
  executionRole=null,
  taskrole=null,
  inheritFrom=null,
  sharedMemorySize=64
)

def ecsCloud = new ECSCloud(
  name=cloudName,
  credentialsId=cloudCredentialsId,
  cluster=cloudClusterName
)

ecsCloud.templates = Arrays.asList(taskTemplate)
ecsCloud.regionName = regionName
ecsCloud.jenkinsUrl = jenkinsUrl

def clouds = instance.clouds
clouds.clear()
clouds.add(ecsCloud)
instance.save()
instance.reload()